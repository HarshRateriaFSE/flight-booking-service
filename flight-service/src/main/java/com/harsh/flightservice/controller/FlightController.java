package com.harsh.flightservice.controller;

import com.harsh.flightservice.Models.Booking;
import com.harsh.flightservice.Models.Flight;
import com.harsh.flightservice.Models.Flights;
import com.harsh.flightservice.Models.User;
import com.harsh.flightservice.repository.FlightRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1.0/flight")
public class FlightController {

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private RestTemplate restTemplate;

    public FlightController(FlightRepository flightRepository, RestTemplate restTemplate) {
        this.flightRepository = flightRepository;
        this.restTemplate = restTemplate;
    }

    @PostMapping(value = "/flightBooking/{pnr}")
    public ResponseEntity<?> bookFlight(@RequestBody Booking booking, @PathVariable("pnr") long pnr) {
        
        Flight flight = new Flight();
        User user = restTemplate.getForObject("http://user-service/api/v1.0/user/" + booking.getUserID(), User.class);
        
        flight.setPnr(pnr);
        flight.setFromCity(booking.getFromCity());
        flight.setToCity(booking.getToCity());
        flight.setDateAndTime(booking.getDateAndTime());
        flight.setAirlines(booking.getAirlines());
        flight.setUserID(booking.getUserID());
        flight.setPassword(user.getPassword());
        flight.setEmailAddress(user.getEmailAddress());
        flight.setContactNumber(user.getContactNumber());

        return ResponseEntity.ok(flightRepository.save(flight));
    }

    @PutMapping(value = "/modifyBooking/{pnr}")
    public ResponseEntity<?> updateFlight(@RequestBody Flight newflight, @PathVariable("pnr") long pnr) {
        
        Flight flight = new Flight();
        
        flight.setPnr(pnr);
        flight.setFromCity(newflight.getFromCity());
        flight.setToCity(newflight.getToCity());
        flight.setDateAndTime(newflight.getDateAndTime());
        flight.setAirlines(newflight.getAirlines());
        flight.setUserID(newflight.getUserID());
        flight.setPassword(newflight.getPassword());
        flight.setEmailAddress(newflight.getEmailAddress());
        flight.setContactNumber(newflight.getContactNumber());

        return ResponseEntity.ok(flightRepository.save(flight));
    }

    @DeleteMapping(value = "/cancelBooking/{pnr}")
    public void cancelBooking(@PathVariable("pnr") long pnr) {
        flightRepository.deleteById(pnr);
    }

    @GetMapping(value = "/history")
    public ResponseEntity<?> getAllFlights() {
        Flights flights = new Flights();
        flights.setFlights(flightRepository.findAll());
        return ResponseEntity.ok(flights);
    }

}
