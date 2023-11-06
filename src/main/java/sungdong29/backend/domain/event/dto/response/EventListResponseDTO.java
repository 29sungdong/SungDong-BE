package sungdong29.backend.domain.event.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.event.vo.SimpleEventVo;

import java.util.List;

@Getter
public class EventListResponseDTO {

    List<SimpleEventVo> events;

    @Builder
    private EventListResponseDTO(List<SimpleEventVo> events) {
        this.events = events;
    }

    public static EventListResponseDTO from(List<SimpleEventVo> events) {
        return EventListResponseDTO.builder()
                .events(events)
                .build();
    }
}
