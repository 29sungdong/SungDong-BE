package sungdong29.backend.domain.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.CourseLike;
import sungdong29.backend.domain.course.domain.CoursePlace;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.course.dto.response.CourseIdResponseDTO;
import sungdong29.backend.domain.course.exception.CourseNotFound;
import sungdong29.backend.domain.course.repository.CourseLikeRepository;
import sungdong29.backend.domain.course.repository.CoursePlaceRepository;
import sungdong29.backend.domain.course.repository.CourseRepository;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.exception.PlaceNotFound;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final PlaceRepository placeRepository;
    private final CoursePlaceRepository coursePlaceRepository;
    private final CourseLikeRepository courseLikeRepository;

    public CourseIdResponseDTO createCourse(UserDetails userDetails, CourseCreateRequestDTO courseCreateRequestDTO) {
        User user = userDetails.getUser();

        // Course 객체 생성
        Course course = Course.of(user, courseCreateRequestDTO);

        // CoursePlace 객체 생성
        int orderNum = 1;
        for (Long placeId : courseCreateRequestDTO.getPlaceIds()) {
            Place place = placeRepository.findById(placeId)
                    .orElseThrow(() -> PlaceNotFound.EXCEPTION);
            CoursePlace coursePlace = CoursePlace.of(course, place, orderNum++);
            coursePlaceRepository.save(coursePlace);
        }
        return CourseIdResponseDTO.from(course.getId());
    }

    public CourseIdResponseDTO updateCourse(UserDetails userDetails, Long courseId, CourseCreateRequestDTO courseInfoRequestDTO) {
        User user = userDetails.getUser();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> CourseNotFound.EXCEPTION);
        List<CoursePlace> coursePlaces = coursePlaceRepository.findByCourse(course);

        for (int i = 0; i < courseInfoRequestDTO.getPlaceIds().size(); i++) {
            Long placeId = courseInfoRequestDTO.getPlaceIds().get(i);
            Place place = placeRepository.findById(placeId)
                    .orElseThrow(() -> PlaceNotFound.EXCEPTION);

            // 코스에 장소가 최대 5가지일때는 이 방법이 괜찮겠지만 장소가 더 많아질 경우에는 이 방법이 적합하지 않을 것 같음
            if (place != coursePlaces.get(i).getPlace()) {
                CoursePlace coursePlace = CoursePlace.of(course, place, i + 1);
                coursePlaceRepository.save(coursePlace);
            }

        }

        // 수정중

        return CourseIdResponseDTO.from(course.getId());
    }

    public void deleteCourse(UserDetails userDetails, Long courseId) {
        User user = userDetails.getUser();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> CourseNotFound.EXCEPTION);
        courseRepository.delete(course);
    }

    public void changeCourseLike(UserDetails userDetails, Long courseId) {
        User user = userDetails.getUser();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> CourseNotFound.EXCEPTION);

        if (courseLikeRepository.existsByCourseAndUser(course, user)) {
            courseLikeRepository.deleteByCourseAndUser(course, user);
        } else {
            CourseLike.of(course, user);
        }
    }
}
