package com.example.api.repository;

import com.example.api.model.Flight;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
  List<Flight> findByOrigin(String origin);
  Optional<Flight> findById(Long id);
}
