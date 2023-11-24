package sungdong29.backend.domain.subPlace.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class MissionNotFound extends BaseErrorException {

    public static final MissionNotFound EXCEPTION = new MissionNotFound();

    private MissionNotFound() {
        super(SubPlaceErrorCode.MISSION_NOT_FOUND);
    }
}
