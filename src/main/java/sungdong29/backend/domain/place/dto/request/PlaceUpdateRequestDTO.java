package sungdong29.backend.domain.place.dto.request;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PlaceUpdateRequestDTO {
    private String name;
    private String xCoordinate;
    private String yCoordinate;

    @Builder
    public PlaceUpdateRequestDTO(String name, String xCoordinate, String yCoordinate) {
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
