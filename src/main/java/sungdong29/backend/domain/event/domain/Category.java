package sungdong29.backend.domain.event.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

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

    @JsonValue private final String category;

    @JsonCreator
    public static Category parsing(String inputValue) {
        return Stream.of(Category.values())
                .filter(category -> category.getCategory().equals(inputValue))
                .findFirst()
                .orElse(null);
    }
}
