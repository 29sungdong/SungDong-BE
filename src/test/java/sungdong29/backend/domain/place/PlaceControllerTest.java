package sungdong29.backend.domain.place;

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
import sungdong29.backend.domain.place.service.PlaceService;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BackendApplication.class)
public class PlaceControllerTest {

    private MockMvc mockMvc;

    @Autowired
    PlaceService placeService;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void before(WebApplicationContext wac) {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac)
                .addFilter(new CharacterEncodingFilter("UTF-8", true))
                .alwaysDo(print())
                .build();
    }

    @DisplayName("근처 장소 조회")
    @Test
    void getListPlaces() throws Exception {
        // given
        String xCoordinate = "127.016882564118";
        String yCoordinate = "37.5425862841995";

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places?xCoordinate={xCoordinate}&yCoordinate={yCoordinate}", xCoordinate, yCoordinate)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.places").exists())
                .andExpect(status().isOk());
    }

    @DisplayName("근처 장소 하나 조회")
    @Test
    void getPlaceById() throws Exception {
        // given
        Long id = 1L;
        String name = "다락옥수";

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.place.name").value(name))
                .andExpect(status().isOk());
    }

    @DisplayName("키워드로 장소 조회")
    @Test
    void getPlaceByKeyword() throws Exception {
        // given
        String keyword = "옥수";
        String name = "다락옥수";

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places/search?keyword={keyword}", keyword)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.markers[0].name").value(name))
                .andExpect(status().isOk());
    }

    @DisplayName("근처 마커 리스트 조회")
    @Test
    void getMarkerList() throws Exception {
        // given
        String xCoordinate = "127.016882564118";
        String yCoordinate = "37.5425862841995";
        int limit = 4;

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places/marker?xCoordinate={xCoordinate}&yCoordinate={yCoordinate}&limit={limit}", xCoordinate, yCoordinate, limit)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.markers").exists())
                .andExpect(status().isOk());
    }
}