package sungdong29.backend.domain.place;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.place.dto.response.MarkerListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.service.PlaceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/places")
@Tag(name = "Place")
public class PlaceController {

    private final PlaceService placeService;

    @Operation(summary = "근처 장소 리스트 조회")
    @GetMapping
    public PlaceListResponseDTO getPlaceList(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate) {
        log.info("근처 장소 리스트 조회");
        return placeService.getPlaceList(xCoordinate, yCoordinate);
    }

    @Operation(summary = "근처 장소 하나 조회")
    @GetMapping("/{id}")
    public PlaceResponseDTO getPlaceById(
            @PathVariable Long id) {
        log.info("근처 장소 하나 조회");
        return placeService.getPlaceById(id);
    }

    @Operation(summary = "키워드로 장소 조회")
    @GetMapping("/search")
    public MarkerListResponseDTO getPlaceByKeyword(
            @RequestParam String keyword) {
        log.info("키워드로 장소 조회");
        return placeService.getPlaceByKeyword(keyword);
    }

    @Operation(summary = "근처 마커 리스트 조회")
    @GetMapping("/marker")
    public MarkerListResponseDTO getMarkerList(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate,
            @RequestParam int limit) {
        log.info("근처 마커 리스트 조회");
        return placeService.getMarkerList(xCoordinate, yCoordinate, limit);
    }
}
