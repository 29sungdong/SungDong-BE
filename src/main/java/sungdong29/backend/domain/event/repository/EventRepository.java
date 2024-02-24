package sungdong29.backend.domain.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sungdong29.backend.domain.event.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long>, EventCustomRepository {

    Boolean existsByPlaceIdAndEndDateTimeBefore(Long place_id, LocalDateTime now);
    @Query("SELECT e FROM Event e WHERE e.startDateTime >= :startDate AND e.endDateTime <= :endDate")
    List<Event> findEventsBetweenDates(LocalDateTime startDate, LocalDateTime endDate);
}
