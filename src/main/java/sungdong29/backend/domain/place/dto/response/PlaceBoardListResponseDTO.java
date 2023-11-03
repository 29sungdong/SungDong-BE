package sungdong29.backend.domain.place.dto.response;


import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

import java.util.List;

@Getter
public class PlaceBoardListResponseDTO {

    List<SimplePlaceVo> places;

    @Builder
    private PlaceBoardListResponseDTO(List<SimplePlaceVo> places) {
        this.places = places;
    }

    public static PlaceBoardListResponseDTO from(List<SimplePlaceVo> places) {
        return PlaceBoardListResponseDTO.builder()
                .places(places)
                .build();
    }
}
