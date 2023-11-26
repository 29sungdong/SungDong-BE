package sungdong29.backend.domain.mission.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.domain.mission.dto.response.MissionsResponseDTO;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MissionServiceTest {
    @Autowired
    MissionService missionService;

    @DisplayName("특정 시설 미션 조회 테스트")
    @Test
    @Transactional
    void testFindMissionsSuccess(){
        MissionsResponseDTO missionsResponseDTO = missionService.findMissionsBySubPlaceId(1L);

        assertThat(missionsResponseDTO.getMissions()).isNotNull();
    }
}
