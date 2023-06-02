package com.linera.ReservationFinder.Service;

import com.linera.ReservationFinder.Model.Reservation;
import com.linera.ReservationFinder.Repository.ReservationRepository;

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
    public Optional<Reservation> getReservationById(String id){

        return this.reservationRepository.findById(id);

    }
    @Override
    public List<Reservation> findByAccepted(boolean accepted){
        return this.reservationRepository.findByAccepted(accepted);
    }

    @Override
    public List<Reservation> findAll(){
        return this.reservationRepository.findAll();
    }

    public List<Reservation> findByIdUser(Integer id){
        return this.reservationRepository.findByIdUser(id);
    }
}
