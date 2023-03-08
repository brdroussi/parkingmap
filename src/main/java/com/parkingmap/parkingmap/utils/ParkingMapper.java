package com.parkingmap.parkingmap.utils;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import org.springframework.stereotype.Component;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Component
public class ParkingMapper {
    /**
     * Convertit un objet Parking en un objet ParkingDTO en copiant les propriétés appropriées
     *
     * @param parking
     * @return
     */
    public static ParkingDTO toParkingDTO(Parking parking) {
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setId(parking.getId());
        parkingDTO.setNom(parking.getNom());
        parkingDTO.setNbPlaces(parking.getNb_places());
        parkingDTO.setXlong(parking.getXlong());
        parkingDTO.setYlat(parking.getYlat());
        parkingDTO.setAdresse(parking.getAdresse());
        return parkingDTO;
    }

    /**
     * Convertit un objet ParkingDTO en un objet Parking en copiant les propriétés appropriées
     *
     * @param parkingDTO
     * @return
     */
    public static Parking toParking(ParkingDTO parkingDTO) {
        Parking parking = new Parking();
        parking.setId(parkingDTO.getId());
        parking.setNom(parkingDTO.getNom());
        parking.setNb_places(parkingDTO.getNbPlaces());
        parking.setXlong(parkingDTO.getXlong());
        parking.setYlat(parkingDTO.getYlat());
        parking.setAdresse(parkingDTO.getAdresse());
        return parking;
    }
}