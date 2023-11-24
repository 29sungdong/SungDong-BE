package sungdong29.backend.domain.event.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.event.dto.response.EventListResponseDTO;
import sungdong29.backend.domain.event.enums.SortCategoryType;
import sungdong29.backend.domain.event.helper.EventHelper;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = BackendApplication.class)
class EventServiceTest {

    @Autowired
    EventHelper eventHelper;

    @Autowired
    EventService eventService;

    @DisplayName("장소 아이디로 행사 조회")
    @Test
    void getEventByPlaceId() {
        // given
        Long placeId = 61L;

        // when
        EventListResponseDTO eventListDTO = eventService.getEventList(null, placeId);

        // then
        assertThat(eventListDTO.getEvents().get(0).getPlaceId()).isEqualTo(61L);
    }

    @DisplayName("카테고리로 행사 조회")
    @Test
    void getEventsByCategory() {
        // given
        List<SortCategoryType> category = new ArrayList<>();
        category.add(SortCategoryType.CULTURE);

        // when
        EventListResponseDTO eventListDTO = eventService.getEventList(category, null);

        // then
        assertThat(eventListDTO.getEvents().get(0).getPlaceId()).isEqualTo(61L);
    }
}