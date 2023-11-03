package sungdong29.backend.domain.user.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;
import sungdong29.backend.domain.user.dto.response.UserResponseDTO;
import sungdong29.backend.domain.user.exception.DuplicateNickname;
import sungdong29.backend.domain.user.exception.DuplicateUsername;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
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

    @DisplayName("중복 닉네임 회원가입 테스트")
    @Test
    void testCreateUserDuplicateNickname(){
        UserRequestDTO userRequestDTO = new UserRequestDTO("username2", "nickname", "password", "token");

        assertThrows(DuplicateNickname.class, () -> userService.createUser(userRequestDTO));
    }
}
