package com.parkingmap.parkingmap.service;


import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import org.opengis.referencing.operation.TransformException;

import java.util.List;

public interface ParkingService  {

    // Récupèrer les DTOs de parkings à proximité d'un point de départ en fonction de la latitude, de la longitude et du périmètre de recherche
    List<ParkingDTO> getParkingsProximite(Double latitude, Double longitude, Float perimetre) throws TransformException;

    // Ajouter un parking à la carte
    Parking addParking(Parking parking);

    // Récupèrer tous les parkings sur la carte
    List<Parking> getAllParking();

}
