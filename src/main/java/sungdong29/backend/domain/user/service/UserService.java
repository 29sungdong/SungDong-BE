package sungdong29.backend.domain.user.service;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.user.dto.request.NicknameUpdateRequestDTO;
import sungdong29.backend.domain.user.dto.request.TokenRequestDTO;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;
import sungdong29.backend.domain.user.dto.response.TokenResponseDTO;
import sungdong29.backend.domain.user.dto.response.UserResponseDTO;
import sungdong29.backend.domain.user.exception.DuplicateNickname;
import sungdong29.backend.domain.user.exception.DuplicateUsername;
import sungdong29.backend.domain.user.exception.UserNotFound;
import sungdong29.backend.domain.user.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import sungdong29.backend.global.config.jwt.TokenProvider;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    private void validateDuplicateUsername(String username) {
        if(userRepository.existsByNickname(username)) {
            throw DuplicateUsername.EXCEPTION;
        }
    }

    private void validateDuplicateNickname(String nickname) {
        if(userRepository.existsByNickname(nickname)) {
            throw DuplicateNickname.EXCEPTION;
        }
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        String username = userRequestDTO.getUsername();
        String nickname = userRequestDTO.getNickname();

        validateDuplicateUsername(username);
        validateDuplicateNickname(nickname);

        String password = passwordEncoder.encode(userRequestDTO.getPassword());

        User user = User.builder()
                .username(username)
                .nickname(nickname)
                .password(password)
                .build();
        userRepository.save(user);

        return UserResponseDTO.from(user);
    }

    public TokenResponseDTO createToken(TokenRequestDTO tokenRequestDTO) {
        String username = tokenRequestDTO.getUsername();
        User user = userRepository.findByUsername(username).orElseThrow(()-> UserNotFound.EXCEPTION);

        if (!passwordEncoder.matches(tokenRequestDTO.getPassword(), user.getPassword())) {
            throw UserNotFound.EXCEPTION;
        }

        String accessToken = tokenProvider.createAccessToken(user.getId());

        return TokenResponseDTO.of(user.getId(), accessToken);
    }

    public UserResponseDTO updateUserNickname(Long userId, NicknameUpdateRequestDTO nicknameUpdateRequestDTO) {
        String nickname = nicknameUpdateRequestDTO.getNickname();
        User user = userRepository.findById(userId).orElseThrow(()-> UserNotFound.EXCEPTION);

        validateDuplicateNickname(nickname);
        user.updateNickname(nickname);

        return UserResponseDTO.from(user);
    }
}
