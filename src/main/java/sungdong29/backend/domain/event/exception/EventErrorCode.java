package sungdong29.backend.domain.event.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sungdong29.backend.global.common.dto.ErrorReason;
import sungdong29.backend.global.error.BaseErrorCode;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum EventErrorCode implements BaseErrorCode {
    /* Event */
    EVENT_NOT_FOUND(NOT_FOUND, "EVENT_404_1", "이벤트가 존재하지 않습니다.");
    private HttpStatus status;
    private String code;
    private String reason;

    @Override
    public ErrorReason getErrorReason() {
        return ErrorReason.of(status.value(), code, reason);
    }
}
