package sungdong29.backend.domain.user.dto.response;


import lombok.Builder;
import lombok.Getter;

@Getter
public class TokenResponseDTO {
    private Long id;
    private String token;

    @Builder
    private TokenResponseDTO(Long id, String token) {
        this.id=id;
        this.token=token;
    }

    public static TokenResponseDTO of(Long id, String token) {
        return TokenResponseDTO.builder()
                .id(id)
                .token(token)
                .build();
    }
}
