package org.electrolinera.manager;

import org.electrolinera.model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ReservationManager {

    public Reservation reservation = new Reservation();
    public List<Reservation> reservationList = new ArrayList<>();

    public void AddReservation( int idUser, int idPointCharge,  Date dateStart,  Date dateEnd){
        reservation.setIdUser(idUser);
        reservation.setIdPointCharge(idPointCharge);
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
    }

    public List<Reservation> GetAllReservationByDate(Date dateFrom,Date dateTo){

        Iterator<Reservation> iterator = this.reservationList.iterator();
        List<Reservation> reservationFoundedList = new ArrayList<>();

        while(iterator.hasNext()) {
            Reservation reservationNext = iterator.next();

            if (dateFrom.equals(reservationNext.getDateStart()) && dateTo.equals(reservationNext.getDateEnd()) )
            {
              reservationFoundedList.add(reservationNext);
            }

        }

        return reservationFoundedList;
    }

}


