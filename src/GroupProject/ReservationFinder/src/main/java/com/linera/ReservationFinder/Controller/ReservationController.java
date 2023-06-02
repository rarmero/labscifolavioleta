package com.linera.ReservationFinder.Controller;

import com.linera.ReservationFinder.Model.Reservation;
import com.linera.ReservationFinder.Service.ReservationServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


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

    @RequestMapping(value="/reservations/user/{idUser}",
            method = GET,
            headers = "Accept=application/json")

    public ResponseEntity<List<Reservation>> getAllReservationsbyUser(@PathVariable Integer idUser) {
        try {
            List<Reservation> reservations = new ArrayList<>();

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

    @GetMapping("/reservationsByIntervalDate")
    public ResponseEntity<List<Reservation>> getAllReservationsbyInvertalDate(@RequestParam(required = true) Date dateFrom, Date dateEnd) {
        // TODO: correct error with date
        try {
            List<Reservation> reservations = new ArrayList<>();

            if (dateFrom == null && dateEnd == null )
                reservationService.findAll().forEach(reservations::add);

            else
                reservationService.getAllReservationsByDate(dateFrom,dateEnd).forEach(reservations::add);

            if (reservations.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(reservations, HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
