package com.parkingmap.parkingmap;


import com.parkingmap.parkingmap.dao.ParkingRepository;
import com.parkingmap.parkingmap.dto.ParkingDTO;
import com.parkingmap.parkingmap.service.impl.ParkingServiceImpl;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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

    @InjectMocks
    private ParkingServiceImpl parkingService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test de la méthode GetParkings
     *
     * @throws Exception
     */
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
        List<ParkingDTO> result = parkingService.getParkingsProximite(0.1560, 45.531, 2f);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(1);
    }

}
