package com.parkingmap.parkingmap.dao;


import com.parkingmap.parkingmap.entities.Parking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, String> {

}
