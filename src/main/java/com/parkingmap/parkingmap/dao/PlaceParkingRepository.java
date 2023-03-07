package com.parkingmap.parkingmap.dao;


import com.parkingmap.parkingmap.entities.PlaceParking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceParkingRepository extends JpaRepository<PlaceParking, String> {

    List<PlaceParking> findByParkingId(String parkingId);

}