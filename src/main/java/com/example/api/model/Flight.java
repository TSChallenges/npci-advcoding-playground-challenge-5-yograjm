package com.example.api.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Setter
public class Flight {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String flight;
    private String origin;
    private String destination;
    private int[] speedSeries;
   // private Date date;

}
