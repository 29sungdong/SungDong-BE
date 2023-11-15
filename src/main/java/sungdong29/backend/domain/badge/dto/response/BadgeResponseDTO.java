package sungdong29.backend.domain.badge.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.badge.domain.Badge;

import java.util.List;

@Getter
public class BadgeResponseDTO {
    private Long id;
    private String category;
    private String imageUrl;
    private List<UserBadgeResponseDTO> achievedBadges;

    @Builder
    private BadgeResponseDTO(Long id, String category, String imageUrl, List<UserBadgeResponseDTO> achievedBadges) {
        this.id= id;
        this.category=category;
        this.imageUrl= imageUrl;
        this.achievedBadges=achievedBadges;
    }

    public static BadgeResponseDTO of(Badge badge, List<UserBadgeResponseDTO> userBadges) {
        return BadgeResponseDTO.builder()
                .id(badge.getId())
                .category(badge.getCategory())
                .imageUrl(badge.getImageUrl())
                .achievedBadges(userBadges)
                .build();
    }
}
