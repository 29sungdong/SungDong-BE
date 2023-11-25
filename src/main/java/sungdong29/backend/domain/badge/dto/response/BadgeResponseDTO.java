package sungdong29.backend.domain.badge.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.badge.domain.Badge;

import java.util.List;

@Getter
public class BadgeResponseDTO {
    private Long id;
    private String name;
    private String imageUrl;
    private List<UserBadgeResponseDTO> badgeDetail;

    @Builder
    private BadgeResponseDTO(Long id, String name, String imageUrl, List<UserBadgeResponseDTO> badgeDetail) {
        this.id= id;
        this.name=name;
        this.imageUrl= imageUrl;
        this.badgeDetail=badgeDetail;
    }

    public static BadgeResponseDTO of(Badge badge, List<UserBadgeResponseDTO> userBadges) {
        return BadgeResponseDTO.builder()
                .id(badge.getId())
                .name(badge.getName())
                .imageUrl(badge.getImageUrl())
                .badgeDetail(userBadges)
                .build();
    }
}
