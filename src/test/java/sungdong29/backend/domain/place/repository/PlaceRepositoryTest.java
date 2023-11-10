package sungdong29.backend.domain.place.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BackendApplication.class)
public class PlaceRepositoryTest {

    @Autowired
    private PlaceRepository placeRepository;

    @DisplayName("진단 결과 조회")
    @Test
    void findAllByDistanceAsc() {
        // given
        String xCoordinate = "127";
        String yCoordinate = "37";

        // when
        List<Place> places = placeRepository.findAllByDistanceAsc(xCoordinate, yCoordinate);

        // then
        assertThat(places.get(0).getId()).isEqualTo(2L);
    }
}
