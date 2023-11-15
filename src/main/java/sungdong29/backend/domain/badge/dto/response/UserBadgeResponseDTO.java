package sungdong29.backend.domain.badge.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.badge.domain.UserBadge;

@Getter
public class UserBadgeResponseDTO {
    private Long id;
    private String name;

    @Builder
    private UserBadgeResponseDTO(Long id, String name) {
        this.id=id;
        this.name= name;
    }

    public static UserBadgeResponseDTO from(UserBadge userBadge) {
        return UserBadgeResponseDTO.builder()
                .id(userBadge.getId())
                .name(userBadge.getName())
                .build();
    }
}
