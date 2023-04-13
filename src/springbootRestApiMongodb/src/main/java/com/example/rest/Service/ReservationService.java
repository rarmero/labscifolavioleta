package com.example.rest.Service;

import java.util.List;
import java.util.Date;

import com.example.rest.Model.Reservation;
import org.apache.catalina.User;

import java.util.Optional;

public interface ReservationService {
    
    List<Reservation> getAllReservationsByDate(Date dateFrom,Date dateTo);
    Reservation saveReservation(Reservation reservation);
    Optional<Reservation> getReservationById(String id);
    Reservation updateReservation(Reservation reservation);
    void deleteReservationById(String id);
    List<Reservation> findAll();
    List<Reservation> findByIdUser(Integer idUser);
}
