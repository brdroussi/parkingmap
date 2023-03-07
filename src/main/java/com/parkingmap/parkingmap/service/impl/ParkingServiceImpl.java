package com.parkingmap.parkingmap.service.impl;


import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.dto.PlaceParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import com.parkingmap.parkingmap.service.ParkingService;
import com.parkingmap.parkingmap.utils.ParkingMapper;
import org.geotools.referencing.GeodeticCalculator;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.crypto.dsig.TransformException;
import java.util.ArrayList;
import java.util.List;

import static org.geotools.geometry.jts.JTS.toDirectPosition;

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private List<ParkingDTO> parkings;
    @Autowired
    private List<PlaceParkingDTO> placeParkings;

    public ParkingServiceImpl() {
        super();
    }
    @Override
    public List<Parking> getAllParking() throws TransformException {
        return parkingRepository.findAll();
    }
    @Override
    public Parking addParking(Parking parking) throws TransformException{
        return parkingRepository.save(parking);
    }

    @Override
    public List<ParkingDTO> getParkings(Double latitude, Double longitude, Float perimetre) throws org.opengis.referencing.operation.TransformException, TransformException {


        GeometryFactory geometryFactory = new GeometryFactory();
        GeodeticCalculator calc = new GeodeticCalculator();
        Coordinate coordinate1 = new Coordinate(longitude , latitude);
        Point p1 = geometryFactory.createPoint(coordinate1);

        List<ParkingDTO> parkingDTOs = new ArrayList<>();
        for (ParkingDTO parking : parkings) {
            if (parking.getXlong() != null && parking.getXlong()!=null) {
                Coordinate coordinate2 = new Coordinate(parking.getXlong() , parking.getYlat());
                Point p2 = geometryFactory.createPoint(coordinate2);
                calc.setStartingPosition(toDirectPosition(p1.getCoordinate(), null));
                calc.setDestinationPosition(toDirectPosition(p2.getCoordinate(), null));
                double distanceParking = calc.getOrthodromicDistance() / 1000; // Convert to kilometers
                if (distanceParking < perimetre) {
                        placeParkings.stream()
                                .filter(placeParking -> parking.getNom().equalsIgnoreCase(placeParking.getNom()))
                                .findFirst()
                                .ifPresent(placeParking -> parking.setNbPlacesDisponible(placeParking.getPlacesDisponibles()));
                    parkingDTOs.add(parking);
                }
            }
        }

        return parkingDTOs;
    }
}