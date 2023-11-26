package sungdong29.backend.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.user.domain.User;

@Getter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String nickname;

    @Builder
    private UserResponseDTO(Long id, String username, String nickname) {
        this.id=id;
        this.username=username;
        this.nickname=nickname;
    }

    public static UserResponseDTO from(User user) {
        return UserResponseDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .nickname(user.getNickname())
                .build();
    }
}
