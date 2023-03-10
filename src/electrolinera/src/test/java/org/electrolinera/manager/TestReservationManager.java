package org.electrolinera.manager;

import com.github.javafaker.Faker;
import org.electrolinera.model.Reservation;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TestReservationManager {


    ReservationManager reservationManagerGlobal = new ReservationManager();
@Test
    public void initDataFaker(){

        Faker faker = new Faker();

        reservationManagerGlobal.reservationList.add(
                new Reservation (faker.idNumber().hashCode(), faker.idNumber().hashCode(),
        faker.date().past(1, TimeUnit.DAYS),faker.date().past(1,TimeUnit.DAYS),Boolean.FALSE));

        reservationManagerGlobal.reservationList.add(
                new Reservation (faker.idNumber().hashCode(), faker.idNumber().hashCode(),
                        faker.date().past(1, TimeUnit.DAYS),faker.date().past(1,TimeUnit.DAYS),Boolean.FALSE));
        reservationManagerGlobal.reservationList.add(
                new Reservation (faker.idNumber().hashCode(), faker.idNumber().hashCode(),
                        faker.date().past(1, TimeUnit.DAYS),faker.date().past(1,TimeUnit.DAYS),Boolean.FALSE));
        reservationManagerGlobal.reservationList.add(
                new Reservation (faker.idNumber().hashCode(), faker.idNumber().hashCode(),
                        faker.date().past(1, TimeUnit.DAYS),faker.date().past(1,TimeUnit.DAYS),Boolean.FALSE));
        reservationManagerGlobal.reservationList.add(
                new Reservation (faker.idNumber().hashCode(), faker.idNumber().hashCode(),
                        faker.date().past(1, TimeUnit.DAYS),faker.date().past(1,TimeUnit.DAYS),Boolean.FALSE));



        reservationManagerGlobal.reservationList.forEach(System.out::println );

    }

    @Test
    public void TestAddReservation() throws ParseException {

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        Reservation reservation = new Reservation(12,11,
                objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false);

        assertEquals(reservation,
                new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

    }

    @Test
    public void  TestGetAllReservationByDate() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        List<Reservation> reservationFoundedList = new ArrayList<>();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager.reservationList.add(new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("22-08-2023"),objSDF.parse("23-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

        reservationFoundedList =  reservationManager.GetAllReservationByDate(objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"));


       //check if some property is in the list of objects

        assertThat(reservationFoundedList, hasItems(
                new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false),
                new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false)
        ));
    }


    @Test
    public void getReservationByIdTest() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();
        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");

        reservation.setDateStart(objSDF.parse("20-08-2023"));
        reservation.setDateStart(objSDF.parse("21-08-2023"));;
        reservation.setAccepted(true);
        reservation.setIdUser(1);
        reservation.setIdPointCharge(1);

        reservationManager.reservationList.add(reservation);

        assertEquals(1,reservationManager.getReservationById(1).getIdUser());
    }

    @Test
    public void getIndexTest() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();
        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager.reservationList.add(new Reservation(1,1,
                objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

        reservationManager.reservationList.add(new Reservation(2,1,
                objSDF.parse("25-08-2023"),  objSDF.parse("26-08-2023"),false));

        assertEquals(1,reservationManager.getIndex(2));
    }


    @Test
    public void saveReservationtest() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager.reservationList.add(new Reservation(1,1,
                objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

        reservationManager.reservationList.add(new Reservation(2,1,
                objSDF.parse("25-08-2023"),objSDF.parse("26-08-2023"),false));

        Reservation reservationToSave = reservationManager.getReservationById(1);

        //reservationManager.reservationList.forEach(System.out::println );

        reservationToSave.setDateStart(objSDF.parse("30-08-2023"));

        reservationManager.saveReservation(reservationManager.getIndex(reservationToSave.getIdUser()),reservationToSave);

        System.out.println(reservationManager.getIndex(reservationToSave.getIdUser()));

        Reservation reservationToCheck = reservationManager.getReservationById(1);

       // reservationManager.reservationList.forEach(System.out::println );

        assertEquals(objSDF.parse("30-08-2023"),
                reservationManager.reservationList.get(
                        reservationManager.getIndex(reservationToSave.getIdUser())
                ).getDateStart()
        ) ;
    }

    @Test
    public void GetAllReservationByDateTest() throws ParseException {
        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        dateStart = objSDF.parse("20-08-2023");
        dateEnd = objSDF.parse("21-08-2023");

        reservationManager.reservationList.add(new Reservation(1,1,dateStart,dateEnd,false));

        dateStart = objSDF.parse("22-08-2023");
        dateEnd = objSDF.parse("23-08-2023");

        reservationManager.reservationList.add(new Reservation(2,1,dateStart,dateEnd,false));

        dateStart = objSDF.parse("25-08-2023");
        dateEnd = objSDF.parse("26-08-2023");

        reservationManager.reservationList.add(new Reservation(3,2,dateStart,dateEnd,false));

        dateStart = objSDF.parse("25-08-2023");
        dateEnd = objSDF.parse("26-08-2023");

        reservationManager.reservationList.add(new Reservation(4,3,dateStart,dateEnd,false));

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList = reservationManager.GetAllReservationByDate(dateStart,dateEnd);

        reservationFoundedList.forEach(System.out::println );

    }
}
