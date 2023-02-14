package org.electrolinera.manager;

import org.electrolinera.model.Reservation;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

        Reservation reservation = new Reservation(12,11,dateStart,dateEnd);

        assertEquals(12,reservation.getIdUser());


    }

    @Test
    public void  TestGetAllReservationByDate() throws ParseException {

        ReservationManager reservationManager = new ReservationManager();

        List<Reservation> reservationFoundedList = new ArrayList<>();

        SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy");
        Date dateStart = objSDF.parse("20-08-2023");
        Date dateEnd = objSDF.parse("21-08-2023");

        reservationManager.reservationList.add(new Reservation(12,11,dateStart,dateEnd));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("22-08-2023"),objSDF.parse("23-08-2023")));
        reservationManager.reservationList.add(new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023")));

        reservationFoundedList =  reservationManager.GetAllReservationByDate(dateStart,dateEnd);


       //check if some property is in the list of objects

        assertThat(reservationFoundedList, hasItems(
                new Reservation(12,11,dateStart,dateEnd),
                new Reservation(13,14,objSDF.parse("20-08-2023"),objSDF.parse("21-08-2023"))
        ));
        
    
    }

}
