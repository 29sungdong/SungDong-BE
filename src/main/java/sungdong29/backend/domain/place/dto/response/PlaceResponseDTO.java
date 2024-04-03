package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;

@Getter
public class PlaceResponseDTO {

    private Long id;
    private String name;
    private Category category;
    private String image;
    private String address;
    private String tel;
    private String openingTime;
    private String closingTime;
    private String xCoordinate;
    private String yCoordinate;
    private Long likeCount;
    private Long courseCount;

    @Builder
    private PlaceResponseDTO(Long id,
                             String name,
                             Category category,
                             String image,
                             String address,
                             String tel,
                             String openingTime,
                             String closingTime,
                             String xCoordinate,
                             String yCoordinate,
                             Long likeCount,
                             Long courseCount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.image = image;
        this.address = address;
        this.tel = tel;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.likeCount = likeCount;
        this.courseCount = courseCount;
    }

    public static PlaceResponseDTO of(Place place, Long likeCount, Long courseCount) {
        return PlaceResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .category(place.getCategory())
                .image(place.getImage())
                .address(place.getAddress())
                .tel(place.getTel())
                .openingTime(place.getOpeningTime())
                .closingTime(place.getClosingTime())
                .xCoordinate(place.getXCoordinate())
                .yCoordinate(place.getYCoordinate())
                .likeCount(likeCount)
                .courseCount(courseCount)
                .build();
    }
}
