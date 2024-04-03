package sungdong29.backend.domain.event.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    PERFORMANCE("공연"),
    EXHIBITION("전시회"),
    POPUP("팝업스토어"),
    EVENT("시설행사");

    private final String category;
}
