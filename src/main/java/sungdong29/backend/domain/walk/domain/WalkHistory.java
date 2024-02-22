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
public class WalkHistory {
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

    @Builder
    private WalkHistory(User user, Place place) {
        this.user=user;
        this.place=place;
    }

    public static WalkHistory of(User user, Place place) {
        return WalkHistory.builder()
                .user(user)
                .place(place)
                .build();
    }
}
