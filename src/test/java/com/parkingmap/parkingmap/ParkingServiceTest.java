package com.parkingmap.parkingmap;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.dto.PlaceParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import com.parkingmap.parkingmap.entities.PlaceParking;
import com.parkingmap.parkingmap.service.impl.ParkingServiceImpl;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import net.minidev.json.JSONObject;
import org.json.JSONArray;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Coordinate;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.operation.TransformException;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Author Brahim DROUSSI
 * 06/03/2023
 */

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class ParkingServiceTest {

    @Mock
    private ParkingRepository parkingRepository;

    @Mock
    private List<ParkingDTO> parkingDTOList;

    @Mock
    private List<PlaceParkingDTO> placeParkings;

    @InjectMocks
    private ParkingServiceImpl parkingService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetParkings() throws Exception {
        // Créer un nouveau parking
        List<ParkingDTO> parkingDTOs = new ArrayList<>();
        ParkingDTO parkingDTO = new ParkingDTO();
        parkingDTO.setId("1ezez");
        parkingDTO.setNom("nop");
        parkingDTO.setNbPlacesDisponible(null);
        parkingDTO.setXlong(45.541);
        parkingDTO.setYlat(0.15151);
        parkingDTO.setAdresse("reiure");
        parkingDTO.setNbPlaces(54);
        parkingDTOs.add(parkingDTO);
        when(parkingDTOList.iterator()).thenReturn(parkingDTOs.iterator());

        // Executer la méthode getParkings() et vérifier les résultats
        List<ParkingDTO> result = parkingService.getParkings(0.1560, 45.531, 2f);
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
    }

}
