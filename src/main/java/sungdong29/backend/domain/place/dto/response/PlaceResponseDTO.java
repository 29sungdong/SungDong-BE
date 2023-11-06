package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.SimplePlaceVo;

@Getter
public class PlaceResponseDTO {

    SimplePlaceVo place;

    @Builder
    private PlaceResponseDTO(SimplePlaceVo place) {
        this.place = place;
    }

    public static PlaceResponseDTO from(SimplePlaceVo place) {
        return PlaceResponseDTO.builder()
                .place(place)
                .build();
    }
}
