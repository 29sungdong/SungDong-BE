package sungdong29.backend.domain.walk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.domain.Walk;

public interface WalkRepository extends JpaRepository<Walk, Long> {
    Long countByUser(User user);
}
