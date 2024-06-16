package sungdong29.backend.domain.place.dto.request;


import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Category;

@Getter
public class PlaceCreateRequestDTO {
    private String name;
    private String address;
    private Category category;
    private String xCoordinate;
    private String yCoordinate;

    @Builder
    public PlaceCreateRequestDTO(String name, String address, Category category, String xCoordinate, String yCoordinate) {
        this.name = name;
        this.address = address;
        this.category = category;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }
}
