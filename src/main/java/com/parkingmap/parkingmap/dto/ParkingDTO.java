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
public class ParkingDTO {

        private String id;
        private String nom;
        private Integer nbPlaces;
        private Integer nbPlacesDisponible;
        private Double xlong;
        private Double ylat;
        private String adresse;

        public ParkingDTO(String id, String nom, Integer nbPlaces, Integer nbPlacesDisponible, Double xlong, Double ylat, String adresse) {
                this.id = id;
                this.nom = nom;
                this.nbPlaces = nbPlaces;
                this.nbPlacesDisponible = nbPlacesDisponible;
                this.xlong = xlong;
                this.ylat = ylat;
                this.adresse = adresse;
        }
}

