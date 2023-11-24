package sungdong29.backend.domain.subPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.subPlace.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}

