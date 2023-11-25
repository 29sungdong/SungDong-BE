package sungdong29.backend.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sungdong29.backend.domain.place.domain.Place;

@Getter
@Setter
public class PlaceResponseDTO {
    private Long id;
    private String name;
    private Boolean isVisited;

    @Builder
    private PlaceResponseDTO(Long id, String name, Boolean isVisited) {
        this.id = id;
        this.name = name;
        this.isVisited = isVisited;
    }

    public static PlaceResponseDTO of(Place place, Boolean isVisited) {
        return PlaceResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .isVisited(isVisited)
                .build();
    }
}
