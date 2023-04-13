/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.rest.Service;
import com.example.rest.Model.Reservation;
import com.example.rest.Repository.ReservationRepository;

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
    public List<Reservation> getAllReservationsByDate(Date dateFrom,Date dateTo){
        return reservationRepository.getAllReservationsByDate(dateFrom, dateTo);
    }

   @Override
    public Reservation saveReservation(Reservation reservation){
        this.reservationRepository.save(reservation);
        return (reservation);
    }
    @Override
    public Optional<Reservation>  getReservationById(String id){
      
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
        List<Reservation> reservations = new ArrayList<>();


        return  reservations;

    }
}
