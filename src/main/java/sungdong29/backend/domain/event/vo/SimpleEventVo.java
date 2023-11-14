package sungdong29.backend.domain.event.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.event.domain.Event;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SimpleEventVo {

    private Long placeId;
    private String name;
    private LocalDateTime endDate;
    private String url;

    @Builder
    private SimpleEventVo(Long placeId, String name, LocalDateTime endDate, String url) {
        this.placeId = placeId;
        this.name = name;
        this.endDate = endDate;
        this.url = url;
    }

    public static SimpleEventVo of(Event event) {
        return SimpleEventVo.builder()
                .placeId(event.getPlace().getId())
                .name(event.getName())
                .endDate(event.getEndDate())
                .url(event.getUrl())
                .build();
    }
}
