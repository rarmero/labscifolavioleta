package com.example.demoH2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoH2.service.ReservationServiceImpl;
import com.example.demoH2.model.Reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations() {

        return   reservationService.getAllReservations();

    }


    @PostMapping(path="/ReservationAdd", consumes = "application/json")
    public String ReservationAdd(@RequestBody Reservation reservation) {

        reservationService.reservationAdd(reservation);

        return reservation.toString();
    }

    @PutMapping("/updateReservation/{id}")
    public String updateUser (@PathVariable Integer id, @RequestBody Reservation dataReservation) {


        Reservation reservationUpdated = reservationService.reservationUpdate(id,dataReservation);

        if (reservationUpdated != null)
            return "Reservation updated by Service properly.\nUser updated: " + reservationUpdated.toString();
        else return "error 418";

    }

    @DeleteMapping("/deleteUser")
    public void deleteUser (@RequestBody Reservation dataReservation){

        reservationService.reservationDelete(dataReservation);

    }

}
