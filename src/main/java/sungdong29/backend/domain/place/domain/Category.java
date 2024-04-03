package sungdong29.backend.domain.place.domain;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    FOOD("음식"),
    CAFE("카페"),
    PUB("주점"),
    PARK("공원"),
    FACILITY("시설"),
    CULTURE("복합문화공간"),
    KIDS("키즈카페"),
    UNIQUE_EXPERIENCE("이색체험"),
    EDUCATION("교육관"),
    PARKING_LOT("주차장"),
    PARKABLE("주차가능"),
    WITH_PET("반려견 동반"),
    ETC("기타");

    private final String category;
}
