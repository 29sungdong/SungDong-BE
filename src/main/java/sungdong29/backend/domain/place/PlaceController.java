package sungdong29.backend.domain.place;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.dto.response.DetailedPlaceResponseDTO;
import sungdong29.backend.domain.place.dto.response.MarkerResponseDTO;
import sungdong29.backend.domain.place.dto.response.SimplePlaceResponseDTO;
import sungdong29.backend.domain.place.service.PlaceService;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/places")
@Tag(name = "Place")
public class PlaceController {

    private final PlaceService placeService;

    @Operation(summary = "장소 하나 조회")
    @GetMapping("/{id}")
    public ResponseEntity<DetailedPlaceResponseDTO> getPlaceById(
            @PathVariable Long id) {
        log.info("장소 하나 조회");
        DetailedPlaceResponseDTO detailedPlaceResponseDTO = placeService.getPlaceById(id);
        return ResponseEntity.ok(detailedPlaceResponseDTO);
    }

    @Operation(summary = "이름 또는 카테고리로 장소 조회")
    @GetMapping("/search")
    public ResponseEntity<List<SimplePlaceResponseDTO>> getPlacesByKeywordAndCategory(
            @RequestParam(value = "category", required = false) Category category,
            @RequestParam(value = "keyword", required = false) String keyword) {
        log.info("이름 또는 카테고리로 장소 조회");
        List<SimplePlaceResponseDTO> placeList = placeService.getPlaceByKeywordAndCategory(category, keyword);
        return ResponseEntity.ok(placeList);
    }

    @Operation(summary = "근처 마커 리스트 조회")
    @GetMapping("/marker")
    public ResponseEntity<List<MarkerResponseDTO>> getMarkerList(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate,
            @RequestParam int limit) {
        log.info("근처 마커 리스트 조회");
        List<MarkerResponseDTO> markerList = placeService.getMarkerList(xCoordinate, yCoordinate, limit);
        return ResponseEntity.ok(markerList);
    }
}
