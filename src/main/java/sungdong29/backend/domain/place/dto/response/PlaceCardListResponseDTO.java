package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.PlaceCardVo;

import java.util.List;

@Getter
public class PlaceCardListResponseDTO {

    List<PlaceCardVo> places;

    @Builder
    private PlaceCardListResponseDTO(List<PlaceCardVo> places) {
        this.places = places;
    }

    public static PlaceCardListResponseDTO from(List<PlaceCardVo> places) {
        return PlaceCardListResponseDTO.builder()
                .places(places)
                .build();
    }

}
