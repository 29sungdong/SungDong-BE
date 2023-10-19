package sungdong29.backend.global.error.exception;


import sungdong29.backend.global.error.BaseErrorException;
import sungdong29.backend.global.error.GlobalErrorCode;

public class NoTokenException extends BaseErrorException {

    public static final BaseErrorException EXCEPTION = new NoTokenException();

    private NoTokenException() {
        super(GlobalErrorCode.NO_TOKEN);
    }
}
