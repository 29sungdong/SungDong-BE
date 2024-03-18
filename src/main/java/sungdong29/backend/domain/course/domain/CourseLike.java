package sungdong29.backend.domain.course.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.user.domain.User;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class CourseLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public CourseLike(Course course, User user) {
        this.course = course;
        this.user = user;
    }

    public static CourseLike of(Course course, User user) {
        return CourseLike.builder()
                .course(course)
                .user(user)
                .build();
    }
}
