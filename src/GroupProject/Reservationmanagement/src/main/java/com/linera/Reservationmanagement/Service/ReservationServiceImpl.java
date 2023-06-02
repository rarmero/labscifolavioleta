package com.linera.Reservationmanagement.Service;

import com.linera.Reservationmanagement.Model.Reservation;
import com.linera.Reservationmanagement.Repository.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public Reservation saveReservation(Reservation reservation){
        this.reservationRepository.save(reservation);
        return (reservation);
    }
    @Override
    public Optional<Reservation> getReservationById(String id){
        return this.reservationRepository.findById(id);
    }

    @Override
    public Reservation updateReservation(Reservation reservation){
        Reservation reservationUpdated= this.reservationRepository.save(reservation);
        return (reservationUpdated);
    }

    @Override
    public void deleteReservationById(String id){
        this.reservationRepository.deleteById(id);
    }

    @Override
    public List<Reservation> findAll(){
        return this.reservationRepository.findAll();
    }

    public List<Reservation> findByIdUser(Integer id){
        return this.reservationRepository.findByIdUser(id);
    }
}