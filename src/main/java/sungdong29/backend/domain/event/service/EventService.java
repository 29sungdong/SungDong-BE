package sungdong29.backend.domain.event.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.dto.response.EventListResponseDTO;
import sungdong29.backend.domain.event.enums.SortCategoryType;
import sungdong29.backend.domain.event.helper.EventHelper;
import sungdong29.backend.domain.event.mapper.EventMapper;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EventService {

    private final EventMapper eventMapper;
    private final EventHelper eventHelper;

    public EventListResponseDTO getEventList(List<SortCategoryType> category, Long placeId) {
        List<Event> events = eventHelper.getEventList(category, placeId);
        return eventMapper.toEventListDTO(events);
    }
}
