package com.linera.Reservationmanagement.Service;


import java.util.List;
import java.util.Date;

import com.linera.Reservationmanagement.Model.Reservation;


import java.util.Optional;

public interface ReservationService {


    Reservation saveReservation(Reservation reservation);
    Optional<Reservation> getReservationById(String id);
    Reservation updateReservation(Reservation reservation);
    void deleteReservationById(String id);


    List<Reservation> findAll();
    List<Reservation> findByIdUser(Integer idUser);

}