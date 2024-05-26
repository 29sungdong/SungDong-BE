package sungdong29.backend.domain.course.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.user.domain.User;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private LocalDate date;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Nullable
    private String image;

    @Column
    @Enumerated(EnumType.STRING)
    private Category category1;

    @Column
    @Nullable
    @Enumerated(EnumType.STRING)
    private Category category2;

    @Column
    @Nullable
    @Enumerated(EnumType.STRING)
    private Category category3;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean byService;


    @Builder
    private Course(
            User user,
            LocalDate date,
            String name,
            String description,
            String image,
            Category category1,
            Category category2,
            Category category3,
            Boolean byService) {
        this.user = user;
        this.date = date;
        this.name = name;
        this.description = description;
        this.image = image;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.byService = byService;
    }

    public static Course of(User user, CourseCreateRequestDTO courseCreateRequestDTO) {
        List<Category> categoryList = courseCreateRequestDTO.getCategoryList();
        for (int i = categoryList.size(); i < 3; i++) {
            categoryList.add(null);
        }
        return Course.builder()
                .user(user)
                .date(courseCreateRequestDTO.getDate())
                .name(courseCreateRequestDTO.getTitle())
                .description(courseCreateRequestDTO.getDescription())
                .image(courseCreateRequestDTO.getImage())
                .category1(categoryList.get(0))
                .category2(categoryList.get(1))
                .category3(categoryList.get(2))
                .byService(courseCreateRequestDTO.getByService())
                .build();
    }
}
