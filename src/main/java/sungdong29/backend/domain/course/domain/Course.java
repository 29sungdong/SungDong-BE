package sungdong29.backend.domain.course.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.user.domain.User;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String name;

    @Column
    private Category category;

    @Column
    private String description;

    @Builder
    private Course(User user, String name, Category category, String description) {
        this.user = user;
        this.name = name;
        this.category = category;
        this.description = description;
    }

    public static Course of(User user,  CourseCreateRequestDTO courseCreateRequestDTO) {
        return Course.builder()
                .user(user)
                .name(courseCreateRequestDTO.getTitle())
                .category(courseCreateRequestDTO.getCategory())
                .description(courseCreateRequestDTO.getDescription())
                .build();
    }
}
