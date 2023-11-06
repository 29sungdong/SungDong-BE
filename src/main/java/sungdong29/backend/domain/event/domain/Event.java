package sungdong29.backend.domain.event.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.global.common.entity.BaseEntity;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Event extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Cascade
    @JsonBackReference
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    private Integer price;

    @NotNull
    private String url;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    @Size(max = 10)
    private LocalDateTime endDate;

    @Builder
    private Event(
            Place place,
            String name,
            Category category,
            Integer price,
            String url,
            LocalDateTime startDate,
            LocalDateTime endDate
    ) {
        this.place = place;
        this.name = name;
        this.category = category;
        this.price = price;
        this.url = url;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    // 정적팩토리메서드
}
