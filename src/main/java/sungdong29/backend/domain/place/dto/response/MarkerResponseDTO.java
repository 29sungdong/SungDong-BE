package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Place;

@Getter
public class MarkerResponseDTO {

    private Long id;
    private String name;
    private String image;
    private String xCoordinate;
    private String yCoordinate;
    private String openingTime;
    private String closingTime;
    private Boolean hasEvent;

    @Builder
    private MarkerResponseDTO(
            Long id,
            String name,
            String image,
            String xCoordinate,
            String yCoordinate,
            String openingTime,
            String closingTime,
            Boolean hasEvent) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.hasEvent = hasEvent;
    }

    public static MarkerResponseDTO of(Place place, Boolean hasEvent) {
        return MarkerResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .image(place.getImage())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .openingTime(place.getOpeningTime())
                .closingTime(place.getClosingTime())
                .hasEvent(hasEvent)
                .build();
    }
}
