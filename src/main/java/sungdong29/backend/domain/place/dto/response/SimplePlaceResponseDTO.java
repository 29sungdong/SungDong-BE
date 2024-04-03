package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.domain.Place;

@Getter
public class SimplePlaceResponseDTO {

    private Long id;
    private String name;
    private String address;
    private Long likeCount;
    private String image;

    @Builder
    private SimplePlaceResponseDTO(Long id, String name, String address, Long likeCount, String image) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.image = image;
        this.likeCount = likeCount;
    }

    public static SimplePlaceResponseDTO of(Place place, Long likeCount) {
        return SimplePlaceResponseDTO.builder()
                .id(place.getId())
                .name(place.getName())
                .address(place.getAddress())
                .image(place.getImage())
                .likeCount(likeCount)
                .build();
    }
}
