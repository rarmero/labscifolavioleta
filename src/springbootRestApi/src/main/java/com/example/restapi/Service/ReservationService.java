package com.example.restapi.Service;

import org.electrolinera.model.Reservation;

import java.util.List;

public interface ReservationService {
    void reservationAdd(Reservation reservation);
    List<Reservation> getAllReservations() ;
    void reservationDelete(Reservation reservation);
    void reservationDeleteById(int reservationId);
    void reservationUpdate(int index,Reservation reservation);
    Reservation reservationDetail(int index);
    Reservation getReservationById(int index);
    Reservation getReservationsByIdUser(int idUser);
}
