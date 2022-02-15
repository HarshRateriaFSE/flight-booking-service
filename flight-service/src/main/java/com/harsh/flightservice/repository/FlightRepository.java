package com.harsh.flightservice.repository;

import com.harsh.flightservice.Models.Flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {


    
}
