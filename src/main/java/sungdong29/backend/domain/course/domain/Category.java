package sungdong29.backend.domain.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    FAMILY("아이와 함께"),
    PET("반려견과 함께"),
    FOR_ME("나만 알고 싶은"),
    FOR_WALK("산책하기 좋은"),
    FOR_DATE("데이트하기 좋은"),
    ATTRACTIONS("볼거리가 많은"),
    QUIET("조용한"),
    PARKING("주차가능한"),
    SCENIC("뷰맛집"),
    FOOD_TOUR("맛집 투어"),
    SEOUL_FOREST("서울숲"),
    PICNIC("피크닉"),
    UNIQUE_EXPERIENCE("이색체험"),
    SUNGDONG_SELECTED("성동산책이 직접 선별한"),
    SUNGDONG_RECOMMENDED("구민이 추천하는");

    private final String category;
}
