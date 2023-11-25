package sungdong29.backend.domain.badge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.badge.domain.Badge;
import sungdong29.backend.domain.badge.domain.Category;

import java.util.Optional;

public interface BadgeRepository extends JpaRepository<Badge, Long> {
    Optional<Badge> findByCategory(Category category);
}
