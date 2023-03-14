package org.electrolinera.manager;

import org.electrolinera.model.Reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationManager {

    public Reservation reservation = new Reservation();
    public List<Reservation> reservationList = new ArrayList<>();

    public void addReservation( Reservation reservation){
        reservationList.add(reservation);
    }

    public List<Reservation> GetAllReservationByDate(Date dateFrom,Date dateTo){

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList =  reservationList.stream()
                .filter(element->element.getDateStart().after(dateFrom) && element.getDateEnd().before(dateTo))
                .collect(Collectors.toList());

        return reservationFoundedList;
    }
    
     public List<Reservation> GetAllReservationByDatePointCharge(Date dateFrom,Date dateTo,int idPointCharge){

         List<Reservation> reservationFoundedList = new ArrayList<>();

         reservationFoundedList =  reservationList.stream()
                 .filter(element->element.getDateStart().after(dateFrom) && element.getDateEnd().before(dateTo) && element.getIdPointCharge() == idPointCharge )
                 .collect(Collectors.toList());


         return reservationFoundedList;
    }

    public List<Reservation> GetAllReservationByDateClient(Date dateFrom,Date dateTo,int idUser){

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList =  reservationList.stream()
                .filter(element->element.getDateStart().after(dateFrom) && element.getDateEnd().before(dateTo) && element.getIdUser() == idUser)
                .collect(Collectors.toList());

        return reservationFoundedList;
    }

    public void AcceptReservation(){
        reservation.setAccepted(true);
    }


    public Reservation getReservationById(long idUser){

        Reservation reservationFilter =
                reservationList.stream()
                        .filter(element->element.getIdUser() == idUser)
                        .findFirst()
                        //.get()
                        .orElse(null);;

        return reservationFilter;
    }

    public Reservation getReservation(int index){

        return reservationList.get(index);
    }

    public int getIndex(Reservation reservation){
        return reservationList.indexOf(reservation);
    }

    public void saveReservation(int index,Reservation reservation){
        reservationList.set(index,reservation);
    }

    public void deleteReservation(Reservation reservation){
        reservationList.remove(reservation);
    }

    public void  updateReservation(int index,Reservation reservation){
        reservationList.set(index,reservation);
    }

}


