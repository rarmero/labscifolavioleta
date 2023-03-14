package com.electrolinera.reserves.Repository;

import com.electrolinera.reserves.service.ReservationService;
import org.electrolinera.manager.ReservationManager;
import org.electrolinera.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservationRepository {

    @Autowired
    private ReservationManager reservationManager;

    public void add(Reservation reservation){
        reservationManager.AddReservation(reservation.getIdUser(),reservation.getIdPointCharge(),
                reservation.getDateStart(),reservation.getDateEnd());

    }

    public  List<Reservation> getAllReservations(){
      return  reservationManager.reservationList;
    }


    public void reservationDelete(Reservation reservation){
        reservationManager.deleteReservation(reservation);

    }

    public void reservationUpdate(int index,Reservation reservation){
        reservationManager.updateReservation(index,reservation);
    }

    public Reservation reservationDetail(int index){
      return  reservationManager.getReservation(index);
    }
}
