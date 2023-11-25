package sungdong29.backend.domain.badge.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Category {
    WELCOME("웰컴"),
    FIRST_STEP("첫 한 걸음"),
    ADVENTURE("구석구석 탐험가"),
    PLACE("장소"),
    SPORT("스포츠 마니아"),
    CULTURE("문화 마에스트로"),
    SCIENCE("과학 탐험가");

    private final String category;
}