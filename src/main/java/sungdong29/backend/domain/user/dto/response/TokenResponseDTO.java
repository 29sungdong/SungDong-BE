package sungdong29.backend.domain.user.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDTO {
    private Long id;
    private String token;

    public static TokenResponseDTO of(Long id, String token) {
        return new TokenResponseDTO(id, token);
    }
}
