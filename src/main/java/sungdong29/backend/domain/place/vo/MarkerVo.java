package sungdong29.backend.domain.place.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.place.domain.Place;

@Getter
@NoArgsConstructor
public class MarkerVo {

    private Long id;
    private String name;
    private String xCoordinate;
    private String yCoordinate;
    private String openingTime;
    private String closingTime;
    private Boolean hasEvent;

    @Builder
    private MarkerVo(
            Long id,
            String name,
            String xCoordinate,
            String yCoordinate,
            String openingTime,
            String closingTime,
            Boolean hasEvent) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.hasEvent = hasEvent;
    }

    public static MarkerVo of(Place place, Boolean hasEvent) {
        return MarkerVo.builder()
                .id(place.getId())
                .name(place.getName())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .openingTime(place.getOpeningTime())
                .closingTime(place.getClosingTime())
                .hasEvent(hasEvent)
                .build();
    }
}
