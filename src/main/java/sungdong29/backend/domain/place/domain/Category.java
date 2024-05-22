package sungdong29.backend.domain.place.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    CAFE("카페"),
    RESTAURANT("음식점"),
    FACILITY("체육시설"),
    NATURE("공원/자연"),
    CULTURE("복합문화공간"),
    KIDS_CAFE("키즈카페"),
    EXPERIENCE("이색체험"),
    EDUCATION("교육관"),
    WITH_EVENT("행사중"),
    LIBRARY("도서관"),
    MARKET("시장"),
    STREET("거리");

    private final String category;
}
