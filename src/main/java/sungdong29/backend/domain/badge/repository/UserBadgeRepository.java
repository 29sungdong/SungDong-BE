package sungdong29.backend.domain.badge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.badge.domain.UserBadge;
import sungdong29.backend.domain.user.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {
    List<UserBadge> findByUserId(Long userId);

    Optional<UserBadge> findByUserAndName(User user, String name);
}
