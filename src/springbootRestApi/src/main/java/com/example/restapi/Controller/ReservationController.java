package com.example.restapi.Controller;


import com.example.restapi.model.Fake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.Service.ReservationServiceImpl;
import org.electrolinera.model.Reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations() {

       return   reservationService.getAllReservations();

    }

    @GetMapping("/greetings")
    public  Reservation GiveGreetings()
    {
        Reservation reservation = new Reservation(12,22,null,null,true);
        return reservation;
    }

    @PostMapping(path="/addFake", consumes = "application/json")
    public String addFake(@RequestBody Fake fake) {

        return  fake.getName();

    }




        @PostMapping(path="/addReservation", consumes = "application/json")
    public String addReservation(@RequestBody Reservation reservation) {

       reservationService.reservationAdd(reservation);

        return reservation.toString();
    }

}
