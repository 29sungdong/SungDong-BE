package sungdong29.backend.domain.place.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.repository.PlaceMapper;
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

    @DisplayName("근처 장소 리스트 조회")
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
}
