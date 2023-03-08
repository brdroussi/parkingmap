package com.parkingmap.parkingmap.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceParkingDTO {
    private String id;
    private String nom;
    private Integer placesDisponibles;

}