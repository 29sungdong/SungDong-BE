package sungdong29.backend.domain.user.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class UserNotFound extends BaseErrorException {
    public static final UserNotFound EXCEPTION = new UserNotFound();

    public UserNotFound() {
        super(UserErrorcode.USER_NOT_FOUND);
    }
}
