package sungdong29.backend.domain.place.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.place.dto.request.PlaceCreateRequestDTO;
import sungdong29.backend.domain.place.dto.request.PlaceUpdateRequestDTO;
import sungdong29.backend.global.common.entity.BaseEntity;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Place extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "place_id")
    private Long id;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    private String address;

    @Nullable
    @Size(max = 20)
    private String tel;

    @NotNull
    @Size(max = 50)
    private String xCoordinate;

    @NotNull
    @Size(max = 50)
    private String yCoordinate;

    @Nullable
    @Size(max = 10)
    private String openingTime;

    @Nullable
    @Size(max = 10)
    private String closingTime;

    @NotNull
    private String image;

    @Builder
    private Place(
            String name,
            Category category,
            String address,
            String tel,
            String xCoordinate,
            String yCoordinate,
            String openingTime,
            String closingTime,
            String image
    ) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
        this.image = image;
    }

    // 정적팩토리메서드
    public static Place of(PlaceCreateRequestDTO placeCreateRequestDTO, String image) {
        return Place.builder()
                .name(placeCreateRequestDTO.getName())
                .category(placeCreateRequestDTO.getCategory())
                .address(placeCreateRequestDTO.getAddress())
                .xCoordinate(placeCreateRequestDTO.getXCoordinate())
                .yCoordinate(placeCreateRequestDTO.getYCoordinate())
                .image(image)
                .tel("")
                .build();
    }

    public void updatePlaceCoordinate(PlaceUpdateRequestDTO placeUpdateRequestDTO) {
        this.xCoordinate = placeUpdateRequestDTO.getXCoordinate();
        this.yCoordinate = placeUpdateRequestDTO.getYCoordinate();
    }
}
