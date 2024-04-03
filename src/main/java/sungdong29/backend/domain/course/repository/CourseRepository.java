package sungdong29.backend.domain.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.Category;
import sungdong29.backend.domain.user.domain.User;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByUser(User user);

    @Query("select c from Course c where c.category1 = :category or c.category2 = :category or c.category3 = :category")
    List<Course> findAllByCategory(Category category);

    List<Course> findAllByNameContaining(String keyword);
}
