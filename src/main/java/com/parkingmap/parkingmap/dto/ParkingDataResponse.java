package com.parkingmap.parkingmap.dto;

import com.parkingmap.parkingmap.entities.Parking;
import lombok.Data;

import java.util.List;

@Data
public class ParkingDataResponse {
    private List<Parking> records;
}
