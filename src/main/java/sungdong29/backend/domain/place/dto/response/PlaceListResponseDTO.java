package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

import java.util.List;

@Getter
public class PlaceListResponseDTO {

    List<SimplePlaceVo> places;

    @Builder
    private PlaceListResponseDTO(List<SimplePlaceVo> places) {
        this.places = places;
    }

    public static PlaceListResponseDTO from(List<SimplePlaceVo> places) {
        return PlaceListResponseDTO.builder()
                .places(places)
                .build();
    }

}
