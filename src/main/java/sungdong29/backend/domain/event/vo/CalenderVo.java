package sungdong29.backend.domain.event.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.event.domain.Event;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class CalenderVo {

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    private List<SimpleEventVo> events;

    @Builder
    private CalenderVo(LocalDateTime date, List<SimpleEventVo> events) {
        this.date = date;
        this.events = events;
    }

    public static CalenderVo of(LocalDateTime date, List<Event> events) {
        List<SimpleEventVo> simpleEvents = events.stream()
                .map(SimpleEventVo::from)
                .toList();
        return CalenderVo.builder()
                .date(date)
                .events(simpleEvents)
                .build();
    }
}
