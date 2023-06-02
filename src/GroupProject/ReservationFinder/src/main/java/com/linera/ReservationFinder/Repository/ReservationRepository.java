package com.linera.ReservationFinder.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.linera.ReservationFinder.Model.Reservation;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;


public interface ReservationRepository extends MongoRepository<Reservation,String>{
    @Query("{ 'idUser' : ?0 }")
    List<Reservation> findByIdUser(Integer idUser);
    @Query("{ 'accepted' : ?0 }")
    List<Reservation> findByAccepted(boolean accepted);
    @Query("{'dateStart' :{'$gte':?0, '$lt':?1}}")
    List<Reservation> getAllReservationsByDate(Date dateFrom,Date dateTo);

}