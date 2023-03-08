package com.parkingmap.parkingmap.utils;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */
public class CreatePointe {

    /**
     * Crée un point à partir des coordonnées géographiques spécifiées.
     *
     * @param longitude La longitude du point.
     * @param latitude La latitude du point.
     * @return Le point créé à partir des coordonnées spécifiées.
     */
    public static Point createPoint(double longitude, double latitude) {
        GeometryFactory geometryFactory = new GeometryFactory();
        Coordinate coordinate = new Coordinate(longitude, latitude);
        return geometryFactory.createPoint(coordinate);
    }
}
