package sungdong29.backend.domain.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    WITH_CHILDREN("아이와 함께"),
    FOR_WALK("산책하기 좋은"),
    FOR_DATE("데이트하기 좋은"),
    PICNIC("피크닉"),
    FOR_ME("나홀로 보내는"),
    BY_SERVICE("문화해설 투어"),
    BY_RESIDENTS("성동구민 픽"),
    BAKERY("베이커리 탐방");

    private final String category;
}
