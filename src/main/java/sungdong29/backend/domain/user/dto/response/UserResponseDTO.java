package sungdong29.backend.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.user.domain.User;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String username;
    private String nickname;

    public static UserResponseDTO from(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getUsername(),
                user.getNickname()
        );
    }
}
