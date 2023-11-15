package sungdong29.backend.domain.subPlace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.subPlace.domain.SubPlace;

import java.util.List;

public interface SubPlaceRepository extends JpaRepository<SubPlace, Long> {
    List<SubPlace> findByPlaceId(Long place_id);
}

