package sungdong29.backend.domain.course.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.CourseLike;
import sungdong29.backend.domain.course.domain.CoursePlace;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.course.dto.response.SimpleCourseResponseDTO;
import sungdong29.backend.domain.course.exception.CourseNotFound;
import sungdong29.backend.domain.course.repository.CourseLikeRepository;
import sungdong29.backend.domain.course.repository.CoursePlaceRepository;
import sungdong29.backend.domain.course.repository.CourseRepository;
import sungdong29.backend.domain.course.domain.Category;
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

    // 내 코스 조회
    public List<SimpleCourseResponseDTO> getMyCourse(UserDetails userDetails) {
        User user = userDetails.getUser();

        List<Course> courseList = courseRepository.findAllByUser(user);

        return courseList.stream()
                .map(course -> SimpleCourseResponseDTO.of(course, courseLikeRepository.countByCourse(course)))
                .toList();
    }

    // 카테고리 별 코스 조회
    public List<SimpleCourseResponseDTO> getCourseByCategory(Category category) {
        List<Course> courseList = courseRepository.findAllByCategory(category);

        return courseList.stream()
                .map(course -> SimpleCourseResponseDTO.of(course, courseLikeRepository.countByCourse(course)))
                .toList();
    }

    // 코스 검색
    public List<SimpleCourseResponseDTO> searchCourse(String keyword) {
        List<Course> courseList = courseRepository.findAllByNameContaining(keyword);

        return courseList.stream()
                .map(course -> SimpleCourseResponseDTO.of(course, courseLikeRepository.countByCourse(course)))
                .toList();
    }

    public List<SimpleCourseResponseDTO> searchCourseByPlace(Long placeId) {
        Place place = placeRepository.findById(placeId)
                .orElseThrow(() -> PlaceNotFound.EXCEPTION);
        List<Course> courseList = coursePlaceRepository.findDistinctCourseByPlace(place);

        return courseList.stream()
                .map(course -> SimpleCourseResponseDTO.of(course, courseLikeRepository.countByCourse(course)))
                .toList();
    }


    public SimpleCourseResponseDTO createCourse(UserDetails userDetails, CourseCreateRequestDTO courseCreateRequestDTO) {
        User user = userDetails.getUser();

        System.out.println("courseCreateRequestDTO = " + courseCreateRequestDTO.getCategoryList());
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
        return SimpleCourseResponseDTO.of(course, 0L);
    }

    public SimpleCourseResponseDTO updateCourse(UserDetails userDetails, Long courseId, CourseCreateRequestDTO courseInfoRequestDTO) {
        User user = userDetails.getUser();
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> CourseNotFound.EXCEPTION);
        Long likeCount = courseLikeRepository.countByCourse(course);
        List<CoursePlace> coursePlaces = coursePlaceRepository.findByCourse(course);

        for (int i = 0; i < courseInfoRequestDTO.getPlaceIds().size(); i++) {
            Long placeId = courseInfoRequestDTO.getPlaceIds().get(i);
            Place place = placeRepository.findById(placeId)
                    .orElseThrow(() -> PlaceNotFound.EXCEPTION);

            if (place != coursePlaces.get(i).getPlace()) {
                CoursePlace coursePlace = CoursePlace.of(course, place, i + 1);
                coursePlaceRepository.save(coursePlace);
            }
        }

        return SimpleCourseResponseDTO.of(course, likeCount);
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
            CourseLike courseLike = CourseLike.of(course, user);
            courseLikeRepository.save(courseLike);
        }
    }
}
