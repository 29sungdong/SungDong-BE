package sungdong29.backend.domain.badge.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Badge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Column
    private String name;

    @NotNull
    @Column
    private String imageUrl;

    @OneToMany(mappedBy = "badge")
    private List<UserBadge> userBadges;

}
