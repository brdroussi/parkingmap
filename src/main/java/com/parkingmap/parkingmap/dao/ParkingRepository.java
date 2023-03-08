package com.parkingmap.parkingmap.dao;


import com.parkingmap.parkingmap.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {

    Parking findParkingById(String id);

}
