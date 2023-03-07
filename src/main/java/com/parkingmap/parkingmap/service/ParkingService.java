package com.parkingmap.parkingmap.service;


import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;

import javax.xml.crypto.dsig.TransformException;
import java.util.List;

public interface ParkingService  {

    List<ParkingDTO> getParkings(Double latitude, Double longitude, Float perimetre) throws org.opengis.referencing.operation.TransformException, TransformException;
    Parking addParking(Parking parking) throws TransformException;
    List<Parking> getAllParking() throws TransformException;


}
