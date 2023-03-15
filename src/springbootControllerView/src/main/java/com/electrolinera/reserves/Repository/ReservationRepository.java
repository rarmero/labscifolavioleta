package com.electrolinera.reserves.Repository;

import com.electrolinera.reserves.service.ReservationService;
import org.electrolinera.manager.ReservationManager;
import org.electrolinera.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class ReservationRepository {

//TODO: see to change the name
    private ReservationManager reservationManager= new ReservationManager();

    public void add(Reservation reservation){
        reservationManager.addReservation(reservation);
    }

    public  List<Reservation> getAllReservations(){
      return  reservationManager.reservationList;
    }

    public Reservation getReservationsByIdUser(long idUser){
        return reservationManager.getReservationById(idUser);
    }

    public void reservationDelete(Reservation reservation){
        reservationManager.deleteReservation(reservation);
    }

    public void reservationDeleteById(int idReservation){
        reservationManager.deleteReservationById(idReservation);
    }

    public void reservationUpdate(int index,Reservation reservation){
        reservationManager.updateReservation(index,reservation);
    }

    public Reservation reservationDetail(int index){
      return  reservationManager.getReservation(index);
    }
    public Reservation getReservationById(int index){
        return  reservationManager.getReservation(index);
    }
}
