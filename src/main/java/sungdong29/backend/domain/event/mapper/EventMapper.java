package sungdong29.backend.domain.event.mapper;

import org.springframework.stereotype.Component;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.dto.response.EventListResponseDTO;
import sungdong29.backend.domain.event.vo.SimpleEventVo;

import java.util.List;

@Component
public class EventMapper {

    public EventListResponseDTO toEventListDTO(List<Event> events) {
        List<SimpleEventVo> mapEvents =
                events.stream()
                        .map(SimpleEventVo::of)
                        .toList();
        return EventListResponseDTO.from(mapEvents);
    }
}
