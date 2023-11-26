package sungdong29.backend.domain.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.user.dto.request.TokenRequestDTO;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BackendApplication.class)
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("회원가입 컨트롤러 테스트")
    @Test
    @Transactional
    public void testSignup() throws Exception {
        UserRequestDTO userRequestDTO = new UserRequestDTO("new_username", "new_nickname", "new_password", "new_token");
        mockMvc.perform(post("/user/signup")
                        .content(objectMapper.writeValueAsString(userRequestDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @DisplayName("로그인 컨트롤러 테스트")
    @Test
    public void testLogin() throws Exception {
        TokenRequestDTO tokenRequestDTO = new TokenRequestDTO("username", "password");
        mockMvc.perform(post("/user/login")
                        .content(objectMapper.writeValueAsString(tokenRequestDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
