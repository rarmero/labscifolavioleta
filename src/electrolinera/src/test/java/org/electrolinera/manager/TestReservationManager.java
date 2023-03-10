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

        for (int i=0 ; i <= 100;i++) {
            reservationManagerGlobal.reservationList.add(
                    new Reservation(faker.idNumber().hashCode(), faker.idNumber().hashCode(),
                            faker.date().past(1, TimeUnit.DAYS), faker.date().past(1, TimeUnit.DAYS), Boolean.FALSE));

        }

     //   reservationManagerGlobal.reservationList.forEach(System.out::println );

    }

    public ReservationManager addData() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager.reservationList.add(new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(12,11,objSDF.parse("10-08-2023"),objSDF.parse("11-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("22-08-2023"),objSDF.parse("23-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

        return reservationManager;
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

        reservationManager= addData();

        //reservationManager.reservationList.forEach(System.out::println );

        List<Reservation> reservationFoundedList = new ArrayList<>();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationFoundedList =  reservationManager.GetAllReservationByDate(objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"));

        reservationManager.reservationList.forEach(System.out::println );

       //check if some property is in the list of objects

        assertThat(reservationFoundedList, hasItems(
                new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false),
                new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false)
        ));
    }

    @Test
    public void GetAllReservationByDateClientTest() throws ParseException {
        ReservationManager reservationManager = new ReservationManager();

        reservationManager= addData();

        //reservationManager.reservationList.forEach(System.out::println );

        List<Reservation> reservationFoundedList = new ArrayList<>();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationFoundedList =  reservationManager.GetAllReservationByDateClient(objSDF.parse("01-08-2023"),objSDF.parse("31-08-2023"),12);

        reservationManager.reservationList.forEach(System.out::println );

        //check if some property is in the list of objects

        assertThat(reservationFoundedList, hasItems(
                new Reservation(12,11,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false),
                new Reservation(12,11,objSDF.parse("10-08-2023"),objSDF.parse("11-08-2023"),false)
        ));
    }

    @Test
    public void getReservationByIdTest() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();
        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager.reservationList.add(
                new Reservation(1,1,objSDF.parse("20-08-2023"),objSDF.parse("20-08-2023"),Boolean.TRUE));

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

        int index = reservationManager.reservationList.indexOf(
                new Reservation(2,1,objSDF.parse("25-08-2023"),  objSDF.parse("26-08-2023"),false)
        );

        assertEquals(1,index);
    }


    @Test
    public void saveReservationTest() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager=addData();

        Reservation reservationToSave = reservationManager.getReservationById(12);

      //  reservationManager.reservationList.forEach(System.out::println );

        reservationToSave.setDateStart(objSDF.parse("30-08-2023"));

        reservationManager.saveReservation(reservationManager.reservationList.indexOf(reservationToSave),reservationToSave);

       // System.out.println(reservationManager.reservationList.indexOf(reservationToSave));

        Reservation reservationToCheck = reservationManager.getReservationById(1);

        reservationManager.reservationList.forEach(System.out::println );

        assertEquals(objSDF.parse("30-08-2023"),
                reservationManager.reservationList.get(
                        reservationManager.reservationList.indexOf(reservationToSave)
                ).getDateStart()
        ) ;
    }

    @Test
    public void GetAllReservationByDateTest() throws ParseException {
        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-MM-yyyy");

        reservationManager= addData();

        reservationManager.reservationList.forEach(System.out::println );

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList = reservationManager.GetAllReservationByDate(objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"));

        reservationFoundedList.forEach(System.out::println );

    }
}
