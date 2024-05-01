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
    private String placeImage;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime startDate;
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm")
    private LocalDateTime endDate;
    private String url;

    @Builder
    private SimpleEventVo(Long placeId, String placeName, String placeImage, String name, LocalDateTime startDate, LocalDateTime endDate, String url) {
        this.placeId = placeId;
        this.placeName = placeName;
        this.placeImage = placeImage;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.url = url;
    }

    public static SimpleEventVo from(Event event) {
        return SimpleEventVo.builder()
                .placeId(event.getPlace().getId())
                .placeName(event.getPlace().getName())
                .placeImage(event.getPlace().getImage())
                .name(event.getName())
                .startDate(event.getStartDateTime())
                .endDate(event.getEndDateTime())
                .url(event.getUrl())
                .build();
    }
}
