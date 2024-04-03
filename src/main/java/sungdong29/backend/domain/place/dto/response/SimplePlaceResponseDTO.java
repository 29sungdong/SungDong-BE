package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;

@Getter
public class SimplePlaceResponseDTO {

    private Long id;
    private String name;
    private Category category;
    private String address;
    private Long likeCount;
    private String image;
    private Long courseCount;

    @Builder
    private SimplePlaceResponseDTO(Long id, String name, Category category, String address, Long likeCount, String image, Long courseCount ) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.address = address;
        this.image = image;
        this.likeCount = likeCount;
        this.courseCount = courseCount;
    }

    public static SimplePlaceResponseDTO of(Place place, Long likeCount, Long courseCount) {
        return SimplePlaceResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .category(place.getCategory())
                .address(place.getAddress())
                .image(place.getImage())
                .likeCount(likeCount)
                .courseCount(courseCount)
                .build();
    }
}
