package sungdong29.backend.domain.subPlace.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sungdong29.backend.global.common.dto.ErrorReason;
import sungdong29.backend.global.error.BaseErrorCode;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum SubPlaceErrorCode implements BaseErrorCode {
    /* Sub Place */
    SUB_PLACE_NOT_FOUND(NOT_FOUND, "SUB_PLACE_404_1", "세부장소가 존재하지 않습니다."),

    /* Mission */
    MISSION_NOT_FOUND(NOT_FOUND, "MISSION_404_1", "미션이 존재하지 않습니다.");
    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
