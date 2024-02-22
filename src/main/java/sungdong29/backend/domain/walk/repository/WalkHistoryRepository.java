package sungdong29.backend.domain.walk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.domain.WalkHistory;

public interface WalkHistoryRepository extends JpaRepository<WalkHistory, Long> {
    Boolean existsByUserIdAndPlaceId(Long userId, Long placeId);
    Long countByUser(User user);
}
