package sungdong29.backend.domain.user.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class DuplicateNickname extends BaseErrorException {
    public static final DuplicateNickname EXCEPTION = new DuplicateNickname();

    public DuplicateNickname() {
        super(UserErrorcode.DUPLICATE_NICKNAME);
    }
}
