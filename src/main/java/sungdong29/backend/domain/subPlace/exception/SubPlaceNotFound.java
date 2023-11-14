package sungdong29.backend.domain.subPlace.exception;

import sungdong29.backend.domain.place.exception.PlaceErrorCode;
import sungdong29.backend.global.error.BaseErrorException;

public class SubPlaceNotFound extends BaseErrorException {

    public static final SubPlaceNotFound EXCEPTION = new SubPlaceNotFound();

    private SubPlaceNotFound() {
        super(PlaceErrorCode.PLACE_NOT_FOUND);
    }
}
