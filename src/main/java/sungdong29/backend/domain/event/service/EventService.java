package sungdong29.backend.domain.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.dto.response.CalenderResponseDTO;
import sungdong29.backend.domain.event.dto.response.EventListResponseDTO;
import sungdong29.backend.domain.event.helper.EventHelper;
import sungdong29.backend.domain.event.mapper.EventMapper;
import sungdong29.backend.domain.event.repository.EventRepository;
import sungdong29.backend.domain.event.vo.CalenderVo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventMapper eventMapper;
    private final EventHelper eventHelper;
    private final EventRepository eventRepository;

    public EventListResponseDTO getEventList(List<Category> category, Long placeId) {
        List<Event> events = eventHelper.getEventList(category, placeId);
        return eventMapper.toEventListDTO(events);
    }

    public CalenderResponseDTO getEventCalender(String startDate, String endDate) {
        LocalDateTime parsedStartDate = LocalDateTime.parse(startDate + "T00:00:00");
        LocalDateTime parsedEndDate = LocalDateTime.parse(endDate + "T23:59:59");
        List<Event> events = eventRepository.findEventsBetweenDates(parsedStartDate, parsedEndDate);

        List<CalenderVo> data = new ArrayList<>();
        for (LocalDateTime date = parsedStartDate; !date.isAfter(parsedEndDate); date = date.plusDays(1)) {
            List<Event> eventsOnDate = eventHelper.filterEventsOnDate(events, date);
            data.add(CalenderVo.of(date, eventsOnDate));
        }
        return CalenderResponseDTO.from(data);
    }
}
