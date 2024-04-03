package sungdong29.backend.domain.place.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.dto.response.SimpleCourseResponseDTO;
import sungdong29.backend.domain.course.repository.CourseLikeRepository;
import sungdong29.backend.domain.course.repository.CoursePlaceRepository;
import sungdong29.backend.domain.event.repository.EventRepository;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.DetailedPlaceResponseDTO;
import sungdong29.backend.domain.place.dto.response.MarkerResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.dto.response.SimplePlaceResponseDTO;
import sungdong29.backend.domain.place.helper.PlaceHelper;
import sungdong29.backend.domain.place.repository.PlaceLikeRepository;
import sungdong29.backend.domain.place.repository.PlaceRepository;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final EventRepository eventRepository;
    private final PlaceLikeRepository placeLikeRepository;
    private final CoursePlaceRepository coursePlaceRepository;
    private final CourseLikeRepository courseLikeRepository;
    private final PlaceHelper placeHelper;

    @Transactional(readOnly = true)
    public DetailedPlaceResponseDTO getPlaceById(Long id) {
        Place place = placeHelper.getPlaceById(id);
        Long likeCount = placeLikeRepository.countByPlace(place);
        Long courseCount = coursePlaceRepository.countDistinctByPlace(place);

        PlaceResponseDTO placeResponseDTO = PlaceResponseDTO.of(place, likeCount, courseCount);
        List<Course> courses = coursePlaceRepository.findDistinctCourseByPlace(place);
        List<SimpleCourseResponseDTO> simpleCourseResponseDTO = courses.stream()
                .map(course -> SimpleCourseResponseDTO.of(course, courseLikeRepository.countByCourse(course)))
                .toList();
        List<Place> places = placeRepository.findByDistanceAscWithLimitExceptMe(place.getXCoordinate(), place.getYCoordinate(), place.getId(), 3);
        List<SimplePlaceResponseDTO> nearbyPlaces = places.stream()
                .map(nearbyPlace -> SimplePlaceResponseDTO.of(nearbyPlace, placeLikeRepository.countByPlace(nearbyPlace), coursePlaceRepository.countDistinctByPlace(nearbyPlace)))
                .toList();

        return DetailedPlaceResponseDTO.of(placeResponseDTO, simpleCourseResponseDTO, nearbyPlaces);
    }

    @Transactional
    public List<SimplePlaceResponseDTO> getPlaceByKeywordAndCategory(Category category, String keyword) {
        List<Place> places;

        if (category == null) {
            places = placeRepository.findByFilter(null, keyword);
        } else if (keyword == null) {
            places = placeRepository.findByFilter(category, null);
        } else {
            places = placeRepository.findByFilter(category, keyword);
        }

        return places.stream()
                .map(place -> SimplePlaceResponseDTO.of(place, placeLikeRepository.countByPlace(place), coursePlaceRepository.countDistinctByPlace(place)))
                .toList();
    }

    @Transactional(readOnly = true)
    public List<MarkerResponseDTO> getMarkerList(String xCoordinate, String yCoordinate, int limit) {
        List<Place> places = placeRepository.findByDistanceAscWithLimit(xCoordinate, yCoordinate, limit);
        return places.stream()
                .map(place -> MarkerResponseDTO.of(place, eventRepository.existsByPlaceIdAndEndDateTimeBefore(place.getId(), LocalDateTime.now())))
                .toList();
    }
}
