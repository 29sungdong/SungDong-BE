package sungdong29.backend.domain.place.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.place.domain.Place;

@Getter
@NoArgsConstructor
public class SimplePlaceVo {

    private Long id;
    private String name;
    private String image;
    private String address;
    private String tel;
    private String openingTime;
    private String closingTime;
    private String xCoordinate;
    private String yCoordinate;

    @Builder
    private SimplePlaceVo(Long id, String name, String image, String address, String tel, String openingTime, String closingTime, String xCoordinate, String yCoordinate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.tel = tel;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public static SimplePlaceVo from(Place place) {
        return SimplePlaceVo.builder()
                .id(place.getId())
                .name(place.getName())
                .image(place.getImage())
                .address(place.getAddress())
                .tel(place.getTel())
                .openingTime(place.getOpeningTime())
                .closingTime(place.getClosingTime())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .build();
    }
}
