package sungdong29.backend.domain.place.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    CULTURE("문화"),
    GYM("체육"),
    PARK("공원");

    private final String category;
}
