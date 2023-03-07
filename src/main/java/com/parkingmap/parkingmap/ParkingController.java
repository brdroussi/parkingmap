package com.parkingmap.parkingmap;


import com.parkingmap.parkingmap.configuration.DataSourceConfiguration;
import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import com.parkingmap.parkingmap.service.ParkingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.opengis.referencing.FactoryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.TransformException;
import java.util.List;

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
    @GetMapping("/proximite")
    public ResponseEntity<List<ParkingDTO>> getParkingsProximite(@RequestParam("latitude")  Double latitude, @RequestParam("longitude") Double longitude, @RequestParam("perimetre") Float perimetre) throws FactoryException, org.opengis.referencing.operation.TransformException, TransformException {

        List<ParkingDTO> parkings = parkingService.getParkings(latitude,longitude,perimetre);
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<ParkingDTO>> getAllParking() {
        return new ResponseEntity<>(parkings, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Parking> addParking(@RequestBody Parking parking){
        Parking newParking =  parkingRepository.save(parking);
        return new ResponseEntity<>(newParking, HttpStatus.OK);
    }

}