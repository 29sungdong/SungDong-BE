package sungdong29.backend.domain.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.event.domain.Event;

import java.time.LocalDateTime;

public interface EventRepository extends JpaRepository<Event, Long>, EventCustomRepository {

    Boolean existsByPlaceIdAndEndDateTimeBefore(Long place_id, LocalDateTime now);
}
