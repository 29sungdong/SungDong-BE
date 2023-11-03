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

    @Builder
    private SimplePlaceVo(Long id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public static SimplePlaceVo of(Place place) {
        return SimplePlaceVo.builder()
                .id(place.getId())
                .name(place.getName())
                .image(place.getImage())
                .build();
    }
}
