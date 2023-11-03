package sungdong29.backend.domain.user.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenRequestDTO {
    private String username;
    private String password;
}
