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

    @Builder
    private MarkerVo(Long id, String name, String xCoordinate, String yCoordinate) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static MarkerVo from(Place place) {
        return MarkerVo.builder()
                .id(place.getId())
                .name(place.getName())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .build();
    }
}
