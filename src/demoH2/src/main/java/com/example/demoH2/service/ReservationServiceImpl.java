package com.example.demoH2.service;

import com.example.demoH2.model.Reservation;
import com.example.demoH2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationServiceImpl {

    @Autowired
    ReservationRepository reservationRepository;

    public Iterable<Reservation> getAllReservations(){

        return  reservationRepository.findAll();
    }

    public void reservationAdd(Reservation reservation){
        reservationRepository.save(reservation);

    }
    public void reservationDelete(Reservation reservation){

           reservationRepository.delete(reservation);
    }

    public Reservation reservationUpdate(Integer idReservation,Reservation reservation)
    {
           reservationRepository.save(reservation);

           return  reservation;
    }

/*
    public Optional<Reservation> reservationDetail(Integer idReservation){

        return reservationRepository.reservationDetail(idReservation);
    }*/
}
