package sungdong29.backend.domain.course.exception;

import sungdong29.backend.global.error.BaseErrorException;

public class CourseNotFound extends BaseErrorException {

    public static final CourseNotFound EXCEPTION = new CourseNotFound();

    private CourseNotFound() {
        super(CourseErrorCode.COURSE_NOT_FOUND);
    }
}
