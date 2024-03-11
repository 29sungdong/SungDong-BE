package sungdong29.backend.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.CourseLike;
import sungdong29.backend.domain.user.domain.User;

public interface CourseLikeRepository extends JpaRepository<CourseLike, Long> {

    boolean existsByCourseAndUser(Course course, User user);

    void deleteByCourseAndUser(Course course, User user);
}
