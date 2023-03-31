package com.example.restapi.Controller;


import com.example.restapi.model.Fake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.restapi.Service.ReservationServiceImpl;
import org.electrolinera.model.Reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ReservationController {

    @Autowired
    ReservationServiceImpl reservationService;

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

    @GetMapping("/reservations")
    public Iterable<Reservation> getAllReservations() {

       return   reservationService.getAllReservations();

    }

    @PostMapping(path="/ReservationAdd", consumes = "application/json")
    public String ReservationAdd(@RequestBody Reservation reservation) {

       reservationService.reservationAdd(reservation);

        return reservation.toString();
    }

    //CRUD: delete
    @DeleteMapping(path="ReservationDelete")
    public ResponseEntity<Reservation> reservationDelete (@RequestParam int idUser) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteReservation");
        headers.add("version","api 1.0");

        Reservation reservationFound  = reservationService.getReservationsByIdUser(idUser);

       // boolean isReservation = reservationFound.isPresent();
       // if(isReservation) {
            //Optional<Book> deletedBook = bookservice.deleteBookById(id);

        reservationService.reservationDelete(reservationFound);

            headers.add("operationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(reservationFound);

            // } else return ResponseEntity.accepted().body(null);
    }

    //CRUD: update
    @PutMapping("/ReservationUpdate/{id}")
    public ResponseEntity<Reservation> updateBook (@PathVariable int idUser, @RequestBody Reservation dataReservation) {

        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","updateReservation");
        headers.add("version","api 1.0");

        Reservation reservation = reservationService.getReservationsByIdUser(idUser);

        //TODO: create method to find by iduser

        return  ResponseEntity.accepted().body(reservation);
    }

}
