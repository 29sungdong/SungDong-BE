package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Place;

@Getter
public class PlaceResponseDTO {

    private Long id;
    private String name;
    private String image;
    private String address;
    private String tel;
    private String openingTime;
    private String closingTime;
    private String xCoordinate;
    private String yCoordinate;
    private Long likeCount;

    @Builder
    private PlaceResponseDTO(Long id,
                             String name,
                             String image,
                             String address,
                             String tel,
                             String openingTime,
                             String closingTime,
                             String xCoordinate,
                             String yCoordinate,
                             Long likeCount) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.address = address;
        this.tel = tel;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.likeCount = likeCount;
    }

    public static PlaceResponseDTO of(Place place, Long likeCount) {
        return PlaceResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .image(place.getImage())
                .address(place.getAddress())
                .tel(place.getTel())
                .openingTime(place.getOpeningTime())
                .closingTime(place.getClosingTime())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .likeCount(likeCount)
                .build();
    }
}
