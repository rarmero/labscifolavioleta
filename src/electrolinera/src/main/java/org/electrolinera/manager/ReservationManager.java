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

    public void AddReservation( int idUser, int idPointCharge,  Date dateStart,  Date dateEnd){
        reservation.setIdUser(idUser);
        reservation.setIdPointCharge(idPointCharge);
        reservation.setDateStart(dateStart);
        reservation.setDateEnd(dateEnd);
    }

    public List<Reservation> GetAllReservationByDate(Date dateFrom,Date dateTo){

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList =  reservationList.stream()
                .filter(element->element.getDateStart().equals(dateFrom) && element.getDateEnd().equals(dateTo))
                .collect(Collectors.toList());

        return reservationFoundedList;
    }
    
     public List<Reservation> GetAllReservationByDatePointCharge(Date dateFrom,Date dateTo,int idPointCharge){

       // Iterator<Reservation> iterator = this.reservationList.iterator();
        List<Reservation> reservationFoundedList = new ArrayList<>();

         reservationFoundedList =  reservationList.stream()
                 .filter(element->element.getDateStart() == dateFrom && element.getDateEnd() == dateTo && element.getIdPointCharge() == idPointCharge )
                 .collect(Collectors.toList());


         return reservationFoundedList;
    }

    public List<Reservation> GetAllReservationByDateClient(Date dateFrom,Date dateTo,int idUser){
//TODO: condition between from

        List<Reservation> reservationFoundedList = new ArrayList<>();

        reservationFoundedList =  reservationList.stream()
                .filter(element->element.getDateStart() == dateFrom && element.getDateEnd() == dateTo && element.getIdUser() == idUser)
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

    public int getIndex(Reservation reservation){

        return reservationList.indexOf(reservation);
    }

    public void saveReservation(int index,Reservation reservation){

        reservationList.set(index,reservation);
    }

}


