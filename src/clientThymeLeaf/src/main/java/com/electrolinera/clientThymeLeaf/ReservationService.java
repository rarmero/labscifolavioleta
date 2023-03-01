package com.electrolinera.clientThymeLeaf;

import org.electrolinera.model.Reservation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    RestTemplate restTemplate  = new RestTemplate();

    public Iterable<Reservation> getAllReservations(String dateStart, String dateEnd) {

        StringBuilder url = new StringBuilder();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-YYYY");
        LocalDate localDate = LocalDate.now();

        if(dateStart.contentEquals("01/01/01")){
            dateStart =  LocalDate.now().toString();
        }

        if(dateEnd.contentEquals("01/01/01")){
            dateEnd =  LocalDate.now().plusDays(1).toString();
        }

           ResponseEntity<List<Reservation>> response = restTemplate.exchange(
                "http://localhost:8081/reservations?datestart=" + dateStart + "&dateend=" + dateEnd,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Reservation>>() {}
        );

         List<Reservation> reservations = response.getBody();

         return reservations;
    }

    public void createReservation(Reservation reservation) {
        //
        HttpEntity<Reservation> request = new HttpEntity<>(reservation);
        restTemplate.postForObject("http://localhost:8081/reservation/reservations", request, Reservation.class);
    }

    public void deleteReservationById(Long id) {
        //
        restTemplate.delete("http://localhost:8081/reservation/reservations/" + id);
    }

    public Optional<Reservation> findReservationByUserId(int id) {
        return null;
    }

}
