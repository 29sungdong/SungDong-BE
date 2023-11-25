package sungdong29.backend.domain.user.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.BackendApplication;
import sungdong29.backend.domain.user.dto.request.TokenRequestDTO;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;
import sungdong29.backend.domain.user.dto.response.UserResponseDTO;
import sungdong29.backend.domain.user.exception.DuplicateUsername;
import sungdong29.backend.domain.user.exception.UserNotFound;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest(classes = BackendApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @DisplayName("회원가입 테스트")
    @Test
    @Transactional
    void testCreateUserSuccess(){
        UserRequestDTO userRequestDTO = new UserRequestDTO("username2", "nickname2", "password", "token");
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);

        assertThat(userResponseDTO.getUsername()).isEqualTo(userRequestDTO.getUsername());
    }

    @DisplayName("중복 아이디 회원가입 테스트")
    @Test
    void testCreateUserDuplicateUsername(){
        UserRequestDTO userRequestDTO = new UserRequestDTO("username", "nickname2", "password", "token");

        assertThrows(DuplicateUsername.class, () -> userService.createUser(userRequestDTO));
    }

    @DisplayName("존재하지 않는 아이디 로그인 테스트")
    @Test
    void testLoginWithNonexistentUsername(){
        TokenRequestDTO tokenRequestDTO = new TokenRequestDTO("no_username", "password");

        assertThrows(UserNotFound.class, () -> userService.createToken(tokenRequestDTO));
    }

    @DisplayName("잘못된 비밀번호 로그인 테스트")
    @Test
    void testLoginWithWrongPassword(){
        TokenRequestDTO tokenRequestDTO = new TokenRequestDTO("username", "wrong_password");

        assertThrows(UserNotFound.class, () -> userService.createToken(tokenRequestDTO));
    }
}
