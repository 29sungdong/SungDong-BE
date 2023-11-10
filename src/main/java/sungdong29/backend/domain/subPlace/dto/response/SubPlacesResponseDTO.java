package sungdong29.backend.domain.subPlace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class SubPlacesResponseDTO {
    List<SubPlaceResponseDTO> subPlaces;
}
