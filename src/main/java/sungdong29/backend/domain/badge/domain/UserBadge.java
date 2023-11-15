package sungdong29.backend.domain.badge.domain;

import jakarta.persistence.*;
import lombok.*;
import sungdong29.backend.domain.user.domain.User;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserBadge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="badge_id")
    private Badge badge;

    private String name;

    @Builder
    private UserBadge(User user, Badge badge, String name) {
        this.user=user;
        this.badge=badge;
        this.name=name;
    }

    public static UserBadge of(User user, Badge badge, String name) {
        return UserBadge.builder()
                .user(user)
                .badge(badge)
                .name(name)
                .build();
    }
}
