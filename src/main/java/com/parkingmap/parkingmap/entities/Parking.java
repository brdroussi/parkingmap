package com.parkingmap.parkingmap.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Entity
@Table(name = "parking")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Parking implements Serializable {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "ylat")
    private Double ylat;

    @Column(name = "xlong")
    private Double xlong;

    @Column(name = "nb_places")
    private Integer nb_places;

    public Parking() {
        super();
    }

    public Parking(String id, String nom, String adresse, Double ylat, Double xlong, Integer nb_places) {
        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.ylat = ylat;
        this.xlong = xlong;
        this.nb_places = nb_places;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Double getYlat() {
        return ylat;
    }

    public void setYlat(Double ylat) {
        this.ylat = ylat;
    }

    public Double getXlong() {
        return xlong;
    }

    public void setXlong(Double xlong) {
        this.xlong = xlong;
    }

    public Integer getNb_places() {
        return nb_places;
    }

    public void setNb_places(Integer nb_places) {
        this.nb_places = nb_places;
    }
}
