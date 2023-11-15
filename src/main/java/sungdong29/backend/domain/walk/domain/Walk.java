package sungdong29.backend.domain.walk.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.user.domain.User;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Walk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="place_id")
    private Place place;

    @CreatedDate
    private LocalDateTime createdAt;

    private Integer steps;

    @Builder
    private Walk(User user, Place place, Integer steps) {
        this.user=user;
        this.place=place;
        this.steps=steps;
    }

    public static Walk of(User user, Place place, Integer steps) {
        return Walk.builder()
                .user(user)
                .place(place)
                .steps(steps)
                .build();
    }
}
