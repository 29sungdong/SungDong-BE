package sungdong29.backend.domain.place.repository;

import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.PlaceBoardListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceCardListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.vo.PlaceCardVo;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

import java.util.List;

@Component
public class PlaceMapper {

    public PlaceBoardListResponseDTO toBoardListDTO(List<Place> places) {
        List<SimplePlaceVo> mapPlaces =
                places.stream()
                        .map(SimplePlaceVo::of)
                        .toList();
        return PlaceBoardListResponseDTO.from(mapPlaces);
    }

    public PlaceCardListResponseDTO toCardListDTO(List<Place> places) {
        List<PlaceCardVo> mapPlaces =
                places.stream()
                        .map(PlaceCardVo::of)
                        .toList();
        return PlaceCardListResponseDTO.from(mapPlaces);
    }

    public PlaceResponseDTO toPlaceDTO(Place place) {
        PlaceCardVo placeCardVo = PlaceCardVo.of(place);
        return PlaceResponseDTO.from(placeCardVo);
    }
}
