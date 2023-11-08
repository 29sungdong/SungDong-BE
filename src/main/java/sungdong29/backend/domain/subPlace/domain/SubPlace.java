package sungdong29.backend.domain.subPlace.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sungdong29.backend.domain.place.domain.Place;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class SubPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    @Size(max = 100)
    private String name;

    @NotNull
    @Column
    private String xCoordinate;
    private String yCoordinate;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
