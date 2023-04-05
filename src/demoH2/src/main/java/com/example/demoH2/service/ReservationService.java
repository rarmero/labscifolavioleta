package com.example.demoH2.service;

import com.example.demoH2.model.Reservation;
import com.example.demoH2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


public interface ReservationService {
    void reservationAdd(Reservation reservation);
    List<Reservation> getAllReservations() ;
    void reservationDelete(Integer idReservation);
    void reservationDeleteByIdUser(Integer idUser);
    Reservation reservationUpdate(Integer idReservation,Reservation reservation);
    Reservation reservationDetail(Integer idReservation);
    Reservation getReservationById(Integer idReservation);
    Reservation getReservationsByIdUser(Integer idUser);


}
