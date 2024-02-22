package sungdong29.backend.domain.walk.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Walk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walk_id")
    private Long id;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Size(max = 50)
    private String xCoordinate;

    @NotNull
    @Size(max = 50)
    private String yCoordinate;
}
