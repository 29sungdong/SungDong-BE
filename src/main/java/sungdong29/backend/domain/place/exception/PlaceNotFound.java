package sungdong29.backend.domain.place.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class PlaceNotFound extends BaseErrorException {

    public static final PlaceNotFound EXCEPTION = new PlaceNotFound();

    private PlaceNotFound() {
        super(PlaceErrorCode.PLACE_NOT_FOUND);
    }
}
