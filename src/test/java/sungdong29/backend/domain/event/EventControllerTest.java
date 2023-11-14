package sungdong29.backend.domain.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.event.enums.SortCategoryType;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BackendApplication.class)
class EventControllerTest {

    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @DisplayName("행사 리스트 카테고리로 조회")
    @Test
    void getEventsByCategory() throws Exception {
        //given
        SortCategoryType type1 = SortCategoryType.PARK;
        SortCategoryType type2 = SortCategoryType.FARM;

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/events?category={type1}&category={type2}", type1, type2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @DisplayName("행사 리스트 장소로 조회")
    @Test
    void getEventsByPlaceId() throws Exception {
        //given
        Long placeId = 1L;

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/events?place_id={placeId}", placeId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }
}