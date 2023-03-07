package com.parkingmap.parkingmap.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.dto.ParkingDataResponse;
import com.parkingmap.parkingmap.dto.PlaceParkingDTO;
import com.parkingmap.parkingmap.entities.Parking;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class DataSourceConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public List<ParkingDTO> parkingData(RestTemplate restTemplate, ObjectMapper objectMapper) {
        String apiUrl = "https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilite-parkings-grand-poitiers-donnees-metiers&rows=1000&facet=nom_du_parking&facet=zone_tarifaire&facet=statut2&facet=statut3";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
        List<ParkingDTO> parkingDTOList = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode records = root.path("records");
            for (JsonNode record : records) {
                JsonNode fields = record.path("fields");
                ParkingDTO parkingDTO = new ParkingDTO();
                parkingDTO.setId(fields.path("id").asText());
                parkingDTO.setNom(fields.path("nom").asText());
                parkingDTO.setNbPlaces(fields.path("nb_places").asInt());
                parkingDTO.setXlong(fields.path("xlong").asDouble());
                parkingDTO.setYlat(fields.path("ylat").asDouble());
                parkingDTO.setAdresse(fields.path("adresse").asText());
                parkingDTOList.add(parkingDTO);
            }
        } catch (JsonProcessingException e) {
            // handle exception
        }
        return parkingDTOList;
    }

    @Bean
    public List<PlaceParkingDTO> parkingPlaceData(RestTemplate restTemplate, ObjectMapper objectMapper) {
        String apiUrl = "https://data.grandpoitiers.fr/api/records/1.0/search/?dataset=mobilites-stationnement-des-parkings-en-temps-reel&facet=nom";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<String> response = restTemplate.exchange(apiUrl, HttpMethod.GET, null, String.class);
        List<PlaceParkingDTO> placeParkingDTOList = new ArrayList<>();
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            JsonNode records = root.path("records");
            for (JsonNode record : records) {
                JsonNode fields = record.path("fields");
                PlaceParkingDTO placeParkingDTO = new PlaceParkingDTO();

                placeParkingDTO.setId(fields.path("id").asText());
                placeParkingDTO.setNom(fields.path("nom").asText());
                placeParkingDTO.setPlacesDisponibles(fields.path("places").asInt());

                placeParkingDTOList.add(placeParkingDTO);
            }
        } catch (JsonProcessingException e) {
            // handle exception
        }
        return placeParkingDTOList;
    }
}
