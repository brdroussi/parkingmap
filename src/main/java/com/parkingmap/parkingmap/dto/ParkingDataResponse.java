package com.parkingmap.parkingmap.dto;

import com.parkingmap.parkingmap.entities.Parking;
import lombok.Data;

import java.util.List;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Data
public class ParkingDataResponse {
    private List<Parking> records;
}
