package sungdong29.backend.domain.subPlace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SubPlacesResponseDTO {
    List<SubPlaceResponseDTO> subPlaces;
}
