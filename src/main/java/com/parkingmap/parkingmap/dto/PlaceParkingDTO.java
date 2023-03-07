package com.parkingmap.parkingmap.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parkingmap.parkingmap.entities.Parking;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceParkingDTO {
    private String id;
    private String nom;
    private Integer placesDisponibles;

}