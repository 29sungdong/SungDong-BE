package sungdong29.backend.domain.place.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.place.dto.response.MarkerListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.mapper.PlaceMapper;
import sungdong29.backend.domain.place.repository.PlaceRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BackendApplication.class)
public class PlaceServiceTest {

    @Autowired
    PlaceRepository placeRepository;

    @Autowired
    PlaceMapper placeMapper;

    @Autowired
    PlaceService placeService;

    @DisplayName("근처 장소 조회")
    @Test
    void getListPlaces() {
        // given
        String xCoordinate = "127";
        String yCoordinate = "37";

        // when
        PlaceListResponseDTO placeListDTO = placeService.getPlaceList(xCoordinate, yCoordinate);

        // then
        assertThat(placeListDTO.getPlaces()).isNotNull();
    }

    @DisplayName("근처 장소 하나 조회")
    @Test
    void getPlaceById() {
        // given
        Long id = 1L;

        // when
        PlaceResponseDTO place = placeService.getPlaceById(id);

        // then
        assertThat(place.getPlace().getId()).isEqualTo(1L);
    }

    @DisplayName("키워드로 장소 조회")
    @Test
    void getPlaceByKeyword() {
        // given
        String keyword1 = "키워드";
        String keyword2 = "공원";

        // when
        MarkerListResponseDTO markers1 = placeService.getPlaceByKeyword(keyword1);
        MarkerListResponseDTO markers2 = placeService.getPlaceByKeyword(keyword2);

        // then
        assertThat(markers1.getMarkers().size()).isEqualTo(0);
        assertThat(markers2.getMarkers().get(0).getName()).contains(keyword2);
    }
}
