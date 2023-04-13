package com.example.rest.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.rest.Model.Reservation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;


public interface ReservationRepository extends MongoRepository<Reservation,String>{
  List<Reservation> findByIdUser(Integer idUser);
  List<Reservation> findByAccepted(boolean accepted);
  @Query("{dateFrom:'?0',dateTo:'?0'}")
  List<Reservation> getAllReservationsByDate(Date dateFrom,Date dateTo);

}
