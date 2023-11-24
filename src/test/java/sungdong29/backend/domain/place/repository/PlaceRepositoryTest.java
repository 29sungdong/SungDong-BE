//package sungdong29.backend.domain.place.repository;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import sungdong29.backend.BackendApplication;
//import sungdong29.backend.domain.place.domain.Place;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//@SpringBootTest(classes = BackendApplication.class)
//public class PlaceRepositoryTest {
//
//    @Autowired
//    private PlaceRepository placeRepository;
//
//    @DisplayName("거리 순 장소 조회")
//    @Test
//    void findAllByDistanceAsc() {
//        // given
//        String xCoordinate = "127";
//        String yCoordinate = "37";
//
//        // when
//        List<Place> places = placeRepository.findAllByDistanceAsc(xCoordinate, yCoordinate);
//
//        // then
//        assertThat(places.get(0).getId()).isEqualTo(2L);
//    }
//
//    @DisplayName("키워드로 장소 조회")
//    @Test
//    void findByNameContaining() {
//        // given
//        String keyword = "공원";
//
//        // when
//        List<Place> places = placeRepository.findByNameContaining(keyword);
//
//        // then
//        assertThat(places.get(0).getName()).contains(keyword);
//    }
//
//    @DisplayName("근처 마커 리스트 조회")
//    @Test
//    void findAllByDistanceAscWithLimit() {
//        // given
//        String xCoordinate = "127";
//        String yCoordinate = "37";
//        int limit = 5;
//
//        // when
//        List<Place> places = placeRepository.findAllByDistanceAscWithLimit(xCoordinate, yCoordinate, limit);
//
//        // then
//        assertThat(places.size()).isEqualTo(5);
//    }
//}
