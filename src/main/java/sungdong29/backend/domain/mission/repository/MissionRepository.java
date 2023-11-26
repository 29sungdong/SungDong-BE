package sungdong29.backend.domain.mission.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.mission.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}

