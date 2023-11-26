package sungdong29.backend.domain.mission;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.mission.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.mission.service.MissionService;
import sungdong29.backend.global.config.LoginUser;
import sungdong29.backend.global.config.user.UserDetails;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/missions")
@Tag(name = "Mission")
public class MissionController {

    private final MissionService missionService;

    @Operation(summary = "특정 시설 미션 목록 조회")
    @GetMapping()
    public ResponseEntity<MissionsResponseDTO> findMissions(@RequestParam("subPlaceId") Long subPlaceId ) {
        MissionsResponseDTO missionsResponseDTO = missionService.findMissionsBySubPlaceId(subPlaceId);
        return ResponseEntity.ok(missionsResponseDTO);
    }

    @Operation(summary = "미션 달성")
    @GetMapping("/{missionId}")
    public void accomplishMission(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable("missionId") Long missionId) {
        log.info("특정 시설 미션 달성");
        missionService.accomplishMission(userDetails, missionId);
    }
}
