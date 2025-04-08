package com.example.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.api.repository.FlightRepository;
import com.example.api.model.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.Optional;



@RestController
public class FlightController {

@Autowired
FlightRepository flightRepository; 

List<Flight> flightList =new ArrayList<Flight>(); 
  @PostMapping("/flight")
  public ResponseEntity<Flight> createFlight(@RequestBody Flight flight){
    long size = flightList.size();
  // flight.setId(size+1);
  // flightList.add(flight);
//  flight.setDate(new Date());

   Flight newFlightDetails =  flightRepository.save(flight);
    return new ResponseEntity<Flight>(newFlightDetails , HttpStatus.CREATED);
  }

    @GetMapping("/flight")
    public ResponseEntity<List<Flight>> getFlights(
            @RequestParam(required = false) String origin,
            @RequestParam(required = false) String orderBy) {
 
        List<Flight> flights;
 
        if (origin != null) {
            flights = flightRepository.findByOrigin(origin);
        } else {
            flights = flightRepository.findAll();
        }
 
        if (orderBy != null) {
            if (orderBy.equals("destination")) {
                flights.sort(Comparator.comparing(Flight::getDestination));
            } else if (orderBy.equals("-destination")) {
                flights.sort(Comparator.comparing(Flight::getId).reversed()); 
            }
        }
 
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }
 
    @GetMapping("/flight/{id}")
public ResponseEntity<Flight> getFlight(@PathVariable Long id) {
    Optional<Flight> optionalFlight = flightRepository.findById(id);
 
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return new ResponseEntity<>(flight, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
}
}
