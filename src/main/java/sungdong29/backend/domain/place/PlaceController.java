package sungdong29.backend.domain.place;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.place.dto.response.PlaceBoardListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceCardListResponseDTO;
import sungdong29.backend.domain.place.service.PlaceService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/places")
@Tag(name = "Place")
public class PlaceController {

    private final PlaceService placeService;

    @Operation(summary = "근처 장소 보드 조회")
    @GetMapping("/board")
    public PlaceBoardListResponseDTO getBoardPlaces(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate) {
        log.info("근처 장소 보드 조회");
        return placeService.getBoardPlaces(xCoordinate, yCoordinate);
    }

    @Operation(summary = "근처 장소 카드리스트 조회")
    @GetMapping("/card")
    public PlaceCardListResponseDTO getListPlaces(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate) {
        log.info("근처 장소 카드리스트 조회");
        return placeService.getListPlaces(xCoordinate, yCoordinate);
    }

    @Operation(summary = "근처 장소 하나 조회")
    @GetMapping("/{id}")
    public PlaceResponseDTO getPlaceById(
            @PathVariable Long id) {
        log.info("근처 장소 하나 조회");
        return placeService.getPlaceById(id);
    }
}
