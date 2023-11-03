package sungdong29.backend.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDTO {
    private String username;
    private String nickname;
    private String password;
    private String deviceToken;
}
