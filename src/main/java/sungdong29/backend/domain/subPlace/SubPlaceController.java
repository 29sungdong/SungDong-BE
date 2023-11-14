package sungdong29.backend.domain.subPlace;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.subPlace.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlaceResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlacesResponseDTO;
import sungdong29.backend.domain.subPlace.service.SubPlaceService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/sub-places")
@Tag(name = "SubPlace")
public class SubPlaceController {

    private final SubPlaceService subPlaceService;

    @Operation(summary = "특정 장소 내 시설 목록 조회")
    @GetMapping("")
    public ResponseEntity<SubPlacesResponseDTO> findSubPlaces(@RequestParam Long placeId) {
        SubPlacesResponseDTO subPlacesResponseDTO = subPlaceService.findSubPlaces(placeId);
        return ResponseEntity.ok(subPlacesResponseDTO);
    }

    @Operation(summary = "특정 시설 미션 목록 조회")
    @GetMapping("/{subPlaceId}/missions")
    public ResponseEntity<MissionsResponseDTO> findMissions(@PathVariable("subPlaceId") Long subPlaceId) {
        MissionsResponseDTO missionsResponseDTO = subPlaceService.findMissionsBySubPlaceId(subPlaceId);
        return ResponseEntity.ok(missionsResponseDTO);
    }

}
