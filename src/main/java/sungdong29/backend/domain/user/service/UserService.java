package sungdong29.backend.domain.user.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.user.dto.request.NicknameUpdateRequestDTO;
import sungdong29.backend.domain.user.dto.request.TokenRequestDTO;
import sungdong29.backend.domain.user.dto.request.UserRequestDTO;
import sungdong29.backend.domain.user.dto.response.StatsResponseDTO;
import sungdong29.backend.domain.user.dto.response.TokenResponseDTO;
import sungdong29.backend.domain.user.dto.response.UserResponseDTO;
import sungdong29.backend.domain.user.exception.DuplicateNickname;
import sungdong29.backend.domain.user.exception.DuplicateUsername;
import sungdong29.backend.domain.user.exception.UserNotFound;
import sungdong29.backend.domain.user.helper.UserHelper;
import sungdong29.backend.domain.user.repository.UserRepository;
import sungdong29.backend.global.config.jwt.TokenProvider;
import sungdong29.backend.global.config.user.UserDetails;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserHelper userHelper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;

    private void validateDuplicateUsername(String username) {
        if(userRepository.existsByUsername(username)) {
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

    public StatsResponseDTO getUserStats(UserDetails userDetails) {
        final User user = userDetails.getUser();
        int placePercent = userHelper.calcPlacePercent(user);
        int missionPercent = userHelper.calcMissionPercent(user);

        return StatsResponseDTO.of(placePercent, missionPercent);
    }
}
