package sungdong29.backend.global.error.exception;


import sungdong29.backend.global.error.BaseErrorException;
import sungdong29.backend.global.error.GlobalErrorCode;

public class TokenValidateException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new TokenValidateException();

    private TokenValidateException() {
        super(GlobalErrorCode.INVALID_AUTH_TOKEN);
    }
}
