package sungdong29.backend.domain.place.mapper;

import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.MarkerListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.vo.MarkerVo;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

import java.util.List;

@Component
public class PlaceMapper {

    public PlaceListResponseDTO toCardListDTO(List<Place> places) {
        List<SimplePlaceVo> mapPlaces =
                places.stream()
                        .map(SimplePlaceVo::from)
                        .toList();
        return PlaceListResponseDTO.from(mapPlaces);
    }

    public PlaceResponseDTO toPlaceDTO(Place place) {
        SimplePlaceVo simplePlaceVo = SimplePlaceVo.from(place);
        return PlaceResponseDTO.from(simplePlaceVo);
    }

    public MarkerListResponseDTO toMarkerListDTO(List<Place> places) {
        List<MarkerVo> mapMarkers =
                places.stream()
                        .map(MarkerVo::from)
                        .toList();
        return MarkerListResponseDTO.from(mapMarkers);
    }
}
