package sungdong29.backend.domain.subPlace.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubPlaceResponseDTO {
    private Long id;
    private String name;
    private String xCoordinate;
    private String yCoordinate;
}
