package com.electrolinera.reserves.service;

import org.electrolinera.model.Reservation;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {

    public  List<Reservation> reservationList =new ArrayList<Reservation>();

    public void reservationAdd(Reservation reservation){

        reservationList.add(reservation);

    }

    public  List<Reservation> getAllReservations(){
        return  reservationList;
    }

    public void reservationDelete(Reservation reservation){
        reservationList.remove(reservation);
    }

    public void reservationUpdate(int index,Reservation reservation)
    {
    reservationList.set(index,reservation);
    }

    public Reservation reservationDetail(int index){

       return reservationList.get(index);
    }
}
