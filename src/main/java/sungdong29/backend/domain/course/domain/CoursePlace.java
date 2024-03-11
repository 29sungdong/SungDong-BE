package sungdong29.backend.domain.course.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.place.domain.Place;

@Entity
@Getter
@NoArgsConstructor(access = lombok.AccessLevel.PROTECTED)
public class CoursePlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = true)
    private Place place;

    @Column
    private int orderNumber;

    @Builder
    private CoursePlace(Course course, Place place, int orderNumber) {
        this.course = course;
        this.place = place;
        this.orderNumber = orderNumber;
    }

    public static CoursePlace of(Course course, Place place, int orderNumber) {
        return CoursePlace.builder()
                .course(course)
                .place(place)
                .orderNumber(orderNumber)
                .build();
    }

    public void updateOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }
}
