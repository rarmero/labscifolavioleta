package com.electrolinera.reserves.service;

import com.electrolinera.reserves.Repository.ReservationRepository;
import org.electrolinera.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{

    @Autowired
    private ReservationRepository reservationRepository;

    public void reservationAdd(Reservation reservation){

        reservationRepository.add(reservation);
    }

    public  List<Reservation> getAllReservations(){

        return  reservationRepository.getAllReservations();
    }

    public Reservation getReservationsByIdUser(int idUser){
        return reservationRepository.getReservationsByIdUser(idUser);
    }
    public Reservation getReservationById(int id){
        return reservationRepository.getReservationById(id);
    }

    public void reservationDelete(Reservation reservation){

        reservationRepository.reservationDelete(reservation);
    }

    public void reservationDeleteById(int reservationId){
        reservationRepository.reservationDeleteById(reservationId);
    }

    public void reservationUpdate(int index,Reservation reservation)
    {
        reservationRepository.reservationUpdate(index,reservation);
    }

    public Reservation reservationDetail(int index){

       return reservationRepository.reservationDetail(index);
    }
}
