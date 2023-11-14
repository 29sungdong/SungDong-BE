package sungdong29.backend.domain.event.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class EventNotFound extends BaseErrorException {

    public static final EventNotFound EXCEPTION = new EventNotFound();

    private EventNotFound() {
        super(EventErrorCode.EVENT_NOT_FOUND);
    }
}
