package sungdong29.backend.domain.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.event.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>, EventCustomRepository {
}
