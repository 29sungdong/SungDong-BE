package sungdong29.backend.domain.subPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.subPlace.domain.UserMission;
import sungdong29.backend.domain.user.domain.User;


public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Long countByUser(User user);
}

