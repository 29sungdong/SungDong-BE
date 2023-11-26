package sungdong29.backend.domain.mission.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class MissionNotFound extends BaseErrorException {
    public static final MissionNotFound EXCEPTION = new MissionNotFound();

    private MissionNotFound() {
        super(MissionErrorCode.MISSION_NOT_FOUND);
    }
}
