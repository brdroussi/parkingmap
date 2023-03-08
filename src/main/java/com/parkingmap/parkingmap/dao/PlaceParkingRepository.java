package com.parkingmap.parkingmap.dao;


import com.parkingmap.parkingmap.entities.PlaceParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Repository
public interface PlaceParkingRepository extends JpaRepository<PlaceParking, String> {

    List<PlaceParking> findByParkingId(String parkingId);

}