package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.PlaceCardVo;

@Getter
public class PlaceResponseDTO {

    PlaceCardVo place;

    @Builder
    private PlaceResponseDTO(PlaceCardVo place) {
        this.place = place;
    }

    public static PlaceResponseDTO from(PlaceCardVo place) {
        return PlaceResponseDTO.builder()
                .place(place)
                .build();
    }
}
