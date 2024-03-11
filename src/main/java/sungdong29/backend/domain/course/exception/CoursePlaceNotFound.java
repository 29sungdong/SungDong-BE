package sungdong29.backend.domain.course.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class CoursePlaceNotFound extends BaseErrorException {

    public static final CoursePlaceNotFound EXCEPTION = new CoursePlaceNotFound();

    private CoursePlaceNotFound() {
        super(CourseErrorCode.COURSE_PLACE_NOT_FOUND);
    }
}
