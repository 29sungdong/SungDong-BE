package sungdong29.backend.domain.event.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.exception.EventNotFound;
import sungdong29.backend.domain.event.repository.EventRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventHelper {

    private final EventRepository eventRepository;

    public List<Event> getEventList(List<Category> categoryList, Long placeId) {
        List<Event> events;

        if (categoryList == null || categoryList.isEmpty()) {
            events = eventRepository.findByFilter(null, placeId);
        }
        else {
            events = eventRepository.findByFilter(categoryList, placeId);
        }

        if (events == null || events.isEmpty()) {
            throw EventNotFound.EXCEPTION;
        }

        return events;
    }

    public List<Event> filterEventsOnDate(List<Event> events, LocalDateTime date) {
        List<Event> eventsOnDate = new ArrayList<>();
        for (Event event : events) {
            if (event.getStartDateTime().isBefore(date) && event.getEndDateTime().isAfter(date)) {
                eventsOnDate.add(event);
            }
        }
        return eventsOnDate;
    }
}
