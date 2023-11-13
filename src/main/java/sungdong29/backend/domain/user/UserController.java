package sungdong29.backend.domain.user;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.user.dto.request.NicknameUpdateRequestDTO;
import sungdong29.backend.domain.user.dto.request.TokenRequestDTO;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;
import sungdong29.backend.domain.user.dto.response.TokenResponseDTO;
import sungdong29.backend.domain.user.dto.response.UserResponseDTO;
import sungdong29.backend.domain.user.service.UserService;
import sungdong29.backend.global.config.LoginUser;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
@Tag(name = "User")
public class UserController {

    private final UserService userService;
    @Operation(summary = "회원가입")
    @PostMapping("signup")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }

    @Operation(summary = "로그인")
    @PostMapping("login")
    public ResponseEntity<TokenResponseDTO> loginUser(@RequestBody TokenRequestDTO tokenRequestDTO) {
        TokenResponseDTO tokenResponseDTO = userService.createToken(tokenRequestDTO);
        return ResponseEntity.ok(tokenResponseDTO);
    }

    @Operation(summary = "닉네임 변경")
    @PatchMapping("nickname")
    public ResponseEntity<UserResponseDTO> updateUserNickname(@LoginUser Long userId, @RequestBody NicknameUpdateRequestDTO nicknameUpdateRequestDTO) {
        UserResponseDTO userResponseDTO = userService.updateUserNickname(userId, nicknameUpdateRequestDTO);
        return ResponseEntity.ok(userResponseDTO);
    }
}
