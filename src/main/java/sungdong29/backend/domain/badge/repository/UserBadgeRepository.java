package sungdong29.backend.domain.badge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.badge.domain.UserBadge;

import java.util.List;

public interface UserBadgeRepository extends JpaRepository<UserBadge, Long> {
    List<UserBadge> findByUserId(Long userId);
}
