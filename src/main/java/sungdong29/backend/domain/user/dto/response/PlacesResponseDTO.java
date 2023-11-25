package sungdong29.backend.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlacesResponseDTO {
    private List<PlaceResponseDTO> places;

    @Builder
    private PlacesResponseDTO(List<PlaceResponseDTO> places) {
        this.places=places;
    }

    public static PlacesResponseDTO from(List<PlaceResponseDTO> places) {
        return PlacesResponseDTO.builder()
                .places(places)
                .build();
    }
}
