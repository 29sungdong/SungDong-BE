package sungdong29.backend.domain.mission.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.subPlace.domain.SubPlace;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "sub_place_id")
    private SubPlace subPlace;
}
