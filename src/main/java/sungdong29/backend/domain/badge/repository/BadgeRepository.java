package sungdong29.backend.domain.badge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.badge.domain.Badge;
import sungdong29.backend.domain.badge.domain.UserBadge;

import java.util.List;

public interface BadgeRepository extends JpaRepository<UserBadge, Long> {
    List<UserBadge> findByUserIdAndIsAchievedTrue(Long userId);
}
