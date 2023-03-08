package com.parkingmap.parkingmap.controller;


import com.parkingmap.parkingmap.configuration.DataSourceConfiguration;
import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import com.parkingmap.parkingmap.service.ParkingService;
import org.opengis.referencing.operation.TransformException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@RestController
@RequestMapping("/parking")
public class ParkingController {
    @Autowired
    private ParkingRepository parkingRepository;
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private DataSourceConfiguration dataSourceConfiguration;
    @Autowired
    private List<ParkingDTO> parkings;

    /**
     * Récupèrer les DTOs de parkings à proximité d'un point de départ en fonction de la latitude, de la longitude et du périmètre de recherche
     *
     * @param latitude
     * @param longitude
     * @param perimetre
     * @return
     * @throws TransformException
     */
    @GetMapping("/proximite")
    public ResponseEntity<List<ParkingDTO>> getParkingsProximite(@RequestParam("latitude")  Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("perimetre") Float perimetre) throws TransformException {

        List<ParkingDTO> parkings = parkingService.getParkings(latitude,longitude,perimetre);
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }

    /**
     * Récupérer un parking avec son id
     *
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<Parking> getParking(@RequestParam("id") String id) {
        Parking parking = parkingService.getParking(id);
        return new ResponseEntity<>(parking, HttpStatus.OK);
    }


    /**
     * Retourner tous les parkings
     *
     * @return
     */
    @GetMapping("/all")
    public ResponseEntity<List<ParkingDTO>> getAllParking() {
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }


    /**
     * Ajouter un nouveau parking
     *
     * @param parking
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Parking> addParking(@RequestBody Parking parking){
        Parking newParking =  parkingService.addParking(parking);
        return new ResponseEntity<>(newParking, HttpStatus.OK);
    }


}