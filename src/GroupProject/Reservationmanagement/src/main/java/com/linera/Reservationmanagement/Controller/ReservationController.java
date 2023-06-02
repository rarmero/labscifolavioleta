package com.linera.Reservationmanagement.Controller;

import com.linera.Reservationmanagement.Model.Reservation;
import com.linera.Reservationmanagement.Service.ReservationServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class ReservationController {

    @Autowired
    private ReservationServiceImpl reservationService;


    @GetMapping("/reservations")
    public ResponseEntity<List<Reservation>> getAllReservations(@RequestParam(required = false) Integer idUser) {
        try {
            List<Reservation> reservations = new ArrayList<>();

            if (idUser == null)
                reservationService.findAll().forEach(reservations::add);

            else
                reservationService.findByIdUser(idUser).forEach(reservations::add);

            if (reservations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(reservations, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/reservationAdd")
    public ResponseEntity addReservation(@RequestBody Reservation reservation){

        try {

            reservationService.saveReservation(reservation);
            return new ResponseEntity<>(reservation, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //CRUD: delete

    @DeleteMapping("reservationDelete")
    public ResponseEntity<Reservation> deleteReservation (@RequestParam String id) {
        //
        HttpHeaders headers = new HttpHeaders();
        headers.add("operation","deleteReservation");
        headers.add("version","api 1.0");

        Optional<Reservation> reservationFound  = reservationService.getReservationById(id);
        boolean isReservation = reservationFound.isPresent();
        if(isReservation) {
            //Optional<Book> deletedBook = bookservice.deleteBookById(id);
            reservationService.deleteReservationById(id);
            headers.add("operationStatus","deleted");
            return  ResponseEntity.accepted().headers(headers).body(reservationFound.get());
        } else return ResponseEntity.accepted().body(null);


    }

    //CRUD: update

    @PutMapping("/reservationUpdate")
    public ResponseEntity<Reservation> updateReservation (@RequestBody Reservation dataReservation) {

        Optional<Reservation> reservationFound = reservationService.getReservationById(dataReservation.getId());

        if (reservationFound.isPresent()) {
            Reservation reservationToUpdate = reservationFound.get();
            //
            reservationToUpdate.setIdUser(dataReservation.getIdUser());
            reservationToUpdate.setIdPointCharge(dataReservation.getIdPointCharge());
            reservationToUpdate.setDateStart(dataReservation.getDateStart());
            reservationToUpdate.setDateEnd(dataReservation.getDateEnd());

            Reservation reservationUpdated = reservationService.updateReservation(reservationToUpdate);
            return ResponseEntity.accepted().body(reservationUpdated);
        } else
            return ResponseEntity.accepted().body(null);

    }


}