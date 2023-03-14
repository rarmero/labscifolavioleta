package com.electrolinera.reserves.service;


import org.electrolinera.model.Reservation;

import java.util.List;

public interface ReservationService {

    void reservationAdd(Reservation reservation);
    List<Reservation> getAllReservations() ;
    void reservationDelete(Reservation reservation);
    void reservationUpdate(int index,Reservation reservation);
    Reservation reservationDetail(int index);

}
