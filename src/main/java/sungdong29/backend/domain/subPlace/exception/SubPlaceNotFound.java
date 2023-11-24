package sungdong29.backend.domain.subPlace.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class SubPlaceNotFound extends BaseErrorException {

    public static final SubPlaceNotFound EXCEPTION = new SubPlaceNotFound();

    private SubPlaceNotFound() {
        super(SubPlaceErrorCode.SUB_PLACE_NOT_FOUND);
    }
}
