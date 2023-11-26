package sungdong29.backend.domain.subPlace.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubPlacesResponseDTO {
    List<SubPlaceResponseDTO> subPlaces;

    @Builder
    private SubPlacesResponseDTO(List<SubPlaceResponseDTO> subPlaces) {
        this.subPlaces = subPlaces;
    }

    public static SubPlacesResponseDTO from(List<SubPlaceResponseDTO> subPlaces) {
        return SubPlacesResponseDTO.builder()
                .subPlaces(subPlaces)
                .build();
    }
}
