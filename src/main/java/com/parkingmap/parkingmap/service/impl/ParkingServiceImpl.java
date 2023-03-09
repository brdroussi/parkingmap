package com.parkingmap.parkingmap.service.impl;

import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.dto.PlaceParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import com.parkingmap.parkingmap.service.ParkingService;
import com.parkingmap.parkingmap.utils.CreatePointe;
import org.geotools.referencing.GeodeticCalculator;
import org.locationtech.jts.geom.Point;
import org.opengis.referencing.operation.TransformException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.geotools.geometry.jts.JTS.toDirectPosition;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@Service
@Transactional
public class ParkingServiceImpl implements ParkingService {
    private ParkingRepository parkingRepository;
    private List<ParkingDTO> parkings;
    private List<PlaceParkingDTO> placeParkings;

    /**
     * Constructeur de la classe ParkingServiceImpl
     *
     * @param parkingRepository Le repository des parkings
     * @param parkings          La liste des DTO de parkings
     * @param placeParkings     La liste des DTO de places de parkings
     */
    public ParkingServiceImpl(ParkingRepository parkingRepository, List<ParkingDTO> parkings, List<PlaceParkingDTO> placeParkings) {
        this.parkingRepository = parkingRepository;
        this.parkings = parkings;
        this.placeParkings = placeParkings;
    }

    /**
     * Récupère tous les parkings enregistrés dans la base de données
     *
     * @return Une liste de parkings
     */
    @Override
    public List<Parking> getAllParking() {
        return parkingRepository.findAll();
    }

    /**
     * Ajoute un parking dans la base de données
     *
     * @param parking Le parking à ajouter
     * @return Le parking ajouté
     */
    @Override
    public Parking addParking(Parking parking) {
        return parkingRepository.save(parking);
    }


    /**
     * Récupère les parkings à proximité d'un point donné
     *
     * @param latitude  La latitude du point
     * @param longitude La longitude du point
     * @param perimetre La distance maximale en kilomètres à laquelle se trouvent les parkings
     * @return Une liste de DTO de parkings
     * @throws TransformException Si une erreur survient lors de la conversion des coordonnées
     */
    @Override
    public List<ParkingDTO> getParkingsProximite(Double latitude, Double longitude, Float perimetre) throws TransformException {

        // Créer un objet GeodeticCalculator pour calculer la distance entre deux points
        GeodeticCalculator calc = new GeodeticCalculator();

        // Créer un point à partir des coordonnées du point de départ
        Point p1 = CreatePointe.createPoint(longitude, latitude);

        // Initialiser une liste de DTO de parkings à retourner
        List<ParkingDTO> parkingDTOs = new ArrayList<>();

        // Parcourir tous les DTO de parkings
        for (ParkingDTO parking : parkings) {
            if (parking.getXlong() != null && parking.getXlong()!=null) {

                // Créer un point à partir des coordonnées du point d'arriver
                Point p2 = CreatePointe.createPoint(parking.getXlong() , parking.getYlat());

                // Calculer la distance entre le point de départ et le parking en utilisant GeodeticCalculator
                calc.setStartingPosition(toDirectPosition(p1.getCoordinate(), null));
                calc.setDestinationPosition(toDirectPosition(p2.getCoordinate(), null));

                // Convertir en kilometre
                double distanceParking = calc.getOrthodromicDistance() / 1000;

                // Vérifier que la distance entre le point de départ et le parking est inférieure au périmètre de recherche
                if (distanceParking < perimetre) {

                    // Récupérer le nombre de place disponibles du parking
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