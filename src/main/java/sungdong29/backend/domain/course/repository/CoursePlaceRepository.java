package sungdong29.backend.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.CoursePlace;

import java.util.List;

public interface CoursePlaceRepository extends JpaRepository<CoursePlace, Long> {
    List<CoursePlace> findByCourse(Course course);
}
