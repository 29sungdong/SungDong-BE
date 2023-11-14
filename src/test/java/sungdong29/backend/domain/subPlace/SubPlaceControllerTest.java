package sungdong29.backend.domain.subPlace;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@WithUserDetails
public class SubPlaceControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("시설 조회 컨트롤러 테스트")
    @Test
    @Transactional
    public void testFindSubPlace() throws Exception {
        mockMvc.perform(get("/sub-places")
                .param("placeId", "1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @DisplayName("미션 조회 컨트롤러 테스트")
    @Test
    @Transactional
    public void testFindMissions() throws Exception {
        mockMvc.perform(get("/sub-places/1/missions"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
