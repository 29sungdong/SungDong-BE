package sungdong29.backend.domain.place.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Place {

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

    @NotNull
    @Size(max = 20)
    private String tel;

    @NotNull
    @Size(max = 50)
    private String xCoordinate;

    @NotNull
    @Size(max = 50)
    private String yCoordinate;

    @NotNull
    @Size(max = 10)
    private String openingTime;

    @NotNull
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
            String closingTime
    ) {
        this.category = category;
        this.name = name;
        this.address = address;
        this.tel = tel;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    // 정적팩토리메서드

}
