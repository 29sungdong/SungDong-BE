package sungdong29.backend.domain.course.domain;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.user.domain.User;

import java.time.LocalDate;

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
    private LocalDate date;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    @Nullable
    private String image;

    @Column
    private Category category1;

    @Column
    @Nullable
    private Category category2;

    @Column
    @Nullable
    private Category category3;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean isSungDongSelected;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean isSungDongRecommended;

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
            Boolean isSungDongSelected,
            Boolean isSungDongRecommended) {
        this.user = user;
        this.date = date;
        this.name = name;
        this.description = description;
        this.image = image;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.isSungDongSelected = isSungDongSelected;
        this.isSungDongRecommended = isSungDongRecommended;
    }

    public static Course of(User user, CourseCreateRequestDTO courseCreateRequestDTO) {
        return Course.builder()
                .user(user)
                .date(courseCreateRequestDTO.getDate())
                .name(courseCreateRequestDTO.getTitle())
                .description(courseCreateRequestDTO.getDescription())
                .image(courseCreateRequestDTO.getImage())
                .category1(courseCreateRequestDTO.getCategoryList().get(0))
                .category2(courseCreateRequestDTO.getCategoryList().get(1))
                .category3(courseCreateRequestDTO.getCategoryList().get(2))
                .isSungDongSelected(courseCreateRequestDTO.getIsSungDongSelected())
                .isSungDongRecommended(courseCreateRequestDTO.getIsSungDongRecommended())
                .build();
    }
}
