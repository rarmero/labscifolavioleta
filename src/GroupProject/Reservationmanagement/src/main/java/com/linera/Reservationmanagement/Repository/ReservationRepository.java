package com.linera.Reservationmanagement.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.linera.Reservationmanagement.Model.Reservation;
import org.springframework.data.mongodb.repository.Query;
import java.util.Date;
import java.util.List;

public interface ReservationRepository extends MongoRepository<Reservation,String> {
    @Query("{ 'idUser' : ?0 }")
    List<Reservation> findByIdUser(Integer idUser);

}