package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.dto.response.SimpleCourseResponseDTO;

import java.util.List;

@Getter
public class DetailedPlaceResponseDTO {

    private PlaceResponseDTO place;
    private List<SimpleCourseResponseDTO> courses;
    private List<SimplePlaceResponseDTO> nearbyPlaces;

    @Builder
    private DetailedPlaceResponseDTO(PlaceResponseDTO placeResponseDTO, List<SimpleCourseResponseDTO> courses, List<SimplePlaceResponseDTO> nearbyPlaces) {
        this.place = placeResponseDTO;
        this.courses = courses;
        this.nearbyPlaces = nearbyPlaces;
    }

    public static DetailedPlaceResponseDTO of(PlaceResponseDTO placeResponseDTO, List<SimpleCourseResponseDTO> courses, List<SimplePlaceResponseDTO> nearbyPlaces) {
        return DetailedPlaceResponseDTO.builder()
                .placeResponseDTO(placeResponseDTO)
                .courses(courses)
                .nearbyPlaces(nearbyPlaces)
                .build();
    }
}
