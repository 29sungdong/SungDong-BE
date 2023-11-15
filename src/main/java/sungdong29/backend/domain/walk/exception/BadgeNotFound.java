package sungdong29.backend.domain.walk.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class BadgeNotFound extends BaseErrorException {

    public static final BadgeNotFound EXCEPTION = new BadgeNotFound();

    private BadgeNotFound() {
        super(BadgeErrorCode.BADGE_NOT_FOUND);
    }
}
