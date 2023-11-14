package sungdong29.backend.domain.subPlace.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.domain.subPlace.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlacesResponseDTO;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SubPlaceServiceTest {
    @Autowired
    SubPlaceService subPlaceService;

    @DisplayName("특정 장소 시설 조회 테스트")
    @Test
    void testFindSubPlacesSuccess(){
        SubPlacesResponseDTO subPlacesResponseDTO = subPlaceService.findSubPlaces(1L);

        assertThat(subPlacesResponseDTO.getSubPlaces()).isNotNull();
    }

    @DisplayName("특정 시설 미션 조회 테스트")
    @Test
    @Transactional
    void testFindMissionsSuccess(){
        MissionsResponseDTO missionsResponseDTO = subPlaceService.findMissionsBySubPlaceId(1L);

        assertThat(missionsResponseDTO.getMissions()).isNotNull();
    }
}
