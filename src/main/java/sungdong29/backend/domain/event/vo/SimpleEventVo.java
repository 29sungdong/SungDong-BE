package sungdong29.backend.domain.event.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.event.domain.Event;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class SimpleEventVo {

    private Long placeId;
    private String placeName;
    private String name;
    @JsonFormat(pattern = "MM/dd HH:mm")
    private LocalDateTime endDate;
    private String url;

    @Builder
    private SimpleEventVo(Long placeId, String placeName, String name, LocalDateTime endDate, String url) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.name = name;
        this.endDate = endDate;
        this.url = url;
    }

    public static SimpleEventVo of(Event event) {
        return SimpleEventVo.builder()
                .placeId(event.getPlace().getId())
                .placeName(event.getPlace().getName())
                .name(event.getName())
                .endDate(event.getEndDateTime())
                .url(event.getUrl())
                .build();
    }
}
