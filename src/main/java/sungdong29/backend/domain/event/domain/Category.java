package sungdong29.backend.domain.event.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    EDUCATION("교육체험"),
    FARM("농장체험"),
    CULTURE("문화행사"),
    EXHIBITION("전시/관람"),
    VOLUNTEER("단체봉사"),
    PARK("공원탐방"),
    FOREST("산림여가");

    private final String category;
}
