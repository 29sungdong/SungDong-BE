package sungdong29.backend.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.course.domain.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
