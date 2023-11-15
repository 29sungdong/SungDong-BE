package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import sungdong29.backend.domain.badge.domain.Badge;
import sungdong29.backend.domain.badge.domain.UserBadge;

@Getter
public class WalkBadgeResponseDTO {
    Badge badge;
    String name;

    @Builder
    private WalkBadgeResponseDTO(Badge badge, String name) {
        this.badge = badge;
        this.name = name;
    }

    public static WalkBadgeResponseDTO from(UserBadge userBadge) {
        return WalkBadgeResponseDTO.builder()
                .badge(userBadge.getBadge())
                .name(userBadge.getName())
                .build();
    }
}
