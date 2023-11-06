package sungdong29.backend.domain.place.repository;

import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

import java.util.List;

@Component
public class PlaceMapper {

    public PlaceListResponseDTO toCardListDTO(List<Place> places) {
        List<SimplePlaceVo> mapPlaces =
                places.stream()
                        .map(SimplePlaceVo::of)
                        .toList();
        return PlaceListResponseDTO.from(mapPlaces);
    }

    public PlaceResponseDTO toPlaceDTO(Place place) {
        SimplePlaceVo simplePlaceVo = SimplePlaceVo.of(place);
        return PlaceResponseDTO.from(simplePlaceVo);
    }
}
