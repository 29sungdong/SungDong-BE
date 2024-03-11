package sungdong29.backend.domain.course.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {

    C1("카테고리1"),
    C2("키테고리2");

    private final String category;
}
