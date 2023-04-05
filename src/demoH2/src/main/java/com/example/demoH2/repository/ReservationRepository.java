package com.example.demoH2.repository;

import com.example.demoH2.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation, Integer> {

}
