package com.parkingmap.parkingmap.entities;

import javax.persistence.*;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */
@Entity
@Table(name = "place_parking")
public class PlaceParking {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parking_id")
    private Parking parking;

    @Column(name = "nom")
    private String nom;

    @Column(name = "places_disponibles")
    private Integer placesDisponibles;

    // Getters et setters
}