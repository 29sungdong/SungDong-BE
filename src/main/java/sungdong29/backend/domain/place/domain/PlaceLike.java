package sungdong29.backend.domain.place.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PlaceLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public PlaceLike(Place place, User user) {
        this.place = place;
        this.user = user;
    }

    public static PlaceLike of(Place place, User user) {
        return PlaceLike.builder()
                .place(place)
                .user(user)
                .build();
    }
}
