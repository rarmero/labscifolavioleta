package com.linera.ReservationFinder.Service;


import java.util.List;
import java.util.Date;

import com.linera.ReservationFinder.Model.Reservation;

import java.util.Optional;

public interface ReservationService {

    List<Reservation> getAllReservationsByDate(Date dateFrom,Date dateTo);
       Optional<Reservation> getReservationById(String id);
    List<Reservation> findAll();
    List<Reservation> findByIdUser(Integer idUser);
    List<Reservation> findByAccepted(boolean accepted);
}

