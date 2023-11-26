package sungdong29.backend.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.mission.domain.UserMission;
import sungdong29.backend.domain.user.domain.User;


public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    Long countByUser(User user);
}

