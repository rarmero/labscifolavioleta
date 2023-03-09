package org.electrolinera.manager;

import org.electrolinera.model.Reservation;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestReservationManager {

    @Test
    public void TestAddReservation() throws ParseException {

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = objSDF.parse("20-08-1023");

        Date dateEnd = objSDF.parse("20-08-1023");

        Reservation reservation = new Reservation(12,11,dateStart,dateEnd,false);

        assertEquals(12,reservation.getIdUser());


    }

    @Test
    public void  TestGetAllReservationByDate() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        List<Reservation> reservationFoundedList = new ArrayList<>();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = objSDF.parse("20-08-2023");
        Date dateEnd = objSDF.parse("21-08-2023");

        reservationManager.reservationList.add(new Reservation(12,11,dateStart,dateEnd,false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("22-08-2023"),objSDF.parse("23-08-2023"),false));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false));

        reservationFoundedList =  reservationManager.GetAllReservationByDate(dateStart,dateEnd);


       //check if some property is in the list of objects

        assertThat(reservationFoundedList, hasItems(
                new Reservation(12,11,dateStart,dateEnd,false),
                new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"),false)
        ));
    }


    @Test
    public void getReservationByIdTest(){

        ReservationManager reservationManager = new ReservationManager();
        long idUser=1;


        Reservation reservation = new Reservation();
        Reservation reservationToCheck = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        try {
            dateStart = objSDF.parse("20-08-2023");
            dateEnd = objSDF.parse("21-08-2023");
        }
        catch(Exception e){

        }

        reservation.setDateStart(dateStart);
        reservation.setDateStart(dateEnd);
        reservation.setAccepted(true);
        reservation.setIdUser(1);
        reservation.setIdPointCharge(1);

        reservationManager.reservationList.add(reservation);

        reservationToCheck = reservationManager.getReservationById(idUser);

        assertEquals(idUser,reservationToCheck.getIdUser());
    }

    @Test
    public void getIndexTest(){

        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        try {
            dateStart = objSDF.parse("20-08-2023");
            dateEnd = objSDF.parse("21-08-2023");
        }
        catch(Exception e){

        }

        reservationManager.reservationList.add(new Reservation(1,1,dateStart,dateEnd,false));

        try {
            dateStart = objSDF.parse("25-08-2023");
            dateEnd = objSDF.parse("26-08-2023");
        }
        catch(Exception e){

        }

        reservationManager.reservationList.add(new Reservation(2,1,dateStart,dateEnd,false));

        assertEquals(1,reservationManager.getIndex(2));
    }


    @Test
    public void saveReservationtest(){

        ReservationManager reservationManager = new ReservationManager();

        Reservation reservation = new Reservation();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        try {
            dateStart = objSDF.parse("20-08-2023");
            dateEnd = objSDF.parse("21-08-2023");
        }
        catch(Exception e){

        }

        reservationManager.reservationList.add(new Reservation(1,1,dateStart,dateEnd,false));

        try {
            dateStart = objSDF.parse("25-08-2023");
            dateEnd = objSDF.parse("26-08-2023");
        }
        catch(Exception e){

        }

        reservationManager.reservationList.add(new Reservation(2,1,dateStart,dateEnd,false));

        Reservation reservationToSave = reservationManager.getReservationById(1);

        Date dateStartToSave = new Date();

        try {
            dateStartToSave = objSDF.parse("20-08-2023");
        }
        catch(Exception e){

        }
        reservationToSave.setDateStart(dateStartToSave);

        reservationManager.saveReservation(reservationManager.getIndex(reservationToSave.getIdUser()),reservationToSave);

        Reservation reservationToCheck = reservationManager.getReservationById(1);


        assertEquals(dateStartToSave,reservationToCheck.getDateStart());
    }

    @Test
    public void GetAllReservationByDateClientTest() throws ParseException {
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


        System.out.printf("");

    }
}
