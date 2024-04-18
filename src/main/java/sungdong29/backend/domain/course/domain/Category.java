package sungdong29.backend.domain.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    WITH_CHILDREN("아이와 함께"),
    WITH_PET("반려견과 함께"),
    FOR_ME("나만 알고 싶은"),
    FOR_WALK("산책하기 좋은"),
    FOR_DATE("데이트하기 좋은"),
    PICNIC("피크닉"),
    QUIET("조용한"),
    PARKING("주차가능한"),
    SEOUL_FOREST("서울숲"),
    BY_SERVICE("성동산책이 직접 선별한"),
    BY_RESIDENTS("구민이 추천하는");

    private final String category;
}
