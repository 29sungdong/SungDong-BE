package sungdong29.backend.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.CoursePlace;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

public interface CoursePlaceRepository extends JpaRepository<CoursePlace, Long> {
    List<CoursePlace> findByCourse(Course course);
    Long countDistinctByPlace(Place place);
    @Query("SELECT DISTINCT cp.course FROM CoursePlace cp WHERE cp.place = :place")
    List<Course> findDistinctCourseByPlace(Place place);

    @Query("SELECT DISTINCT cp.place FROM CoursePlace cp WHERE cp.course = :course")
    List<Place> findPlaceByCourse(Course course);
}
