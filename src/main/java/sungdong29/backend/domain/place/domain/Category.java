package sungdong29.backend.domain.place.domain;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum Category {
    CULTURE("문화"),
    GYM("체육"),
    PARK("공원");

    @JsonValue private final String category;

    @JsonCreator
    public static Category parsing(String inputValue) {
        return Stream.of(Category.values())
                .filter(category -> category.getCategory().equals(inputValue))
                .findFirst()
                .orElse(null);
    }
}
