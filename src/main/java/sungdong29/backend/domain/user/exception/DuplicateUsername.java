package sungdong29.backend.domain.user.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class DuplicateUsername extends BaseErrorException {
    public static final DuplicateUsername EXCEPTION = new DuplicateUsername();

    public DuplicateUsername() {
        super(UserErrorcode.DUPLICATE_USERNAME);
    }
}
