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
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.service.PlaceService;

import static org.assertj.core.api.Assertions.assertThat;
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
    void getPlaceById() throws Exception {
        // given
        Long id = 1L;
        String name = "응봉공원 테니스장";

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.place.name").value(name))
                .andExpect(status().isOk());
    }

    @DisplayName("키워드로 장소 조회")
    @Test
    void testGetPlaceById() throws Exception {
        // given
        String keyword = "공원";
        String name = "응봉공원 테니스장";

        // when, then
        mockMvc.perform(MockMvcRequestBuilders.get("/places/search?keyword={keyword}", keyword)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.markers[0].name").value(name))
                .andExpect(status().isOk());
    }

}