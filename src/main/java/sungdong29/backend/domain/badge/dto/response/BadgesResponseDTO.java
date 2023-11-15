package sungdong29.backend.domain.badge.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class BadgesResponseDTO {
    private List<BadgeResponseDTO> badges;

    @Builder
    private BadgesResponseDTO(List<BadgeResponseDTO> badges) {
        this.badges = badges;
    }

    public static BadgesResponseDTO from(List<BadgeResponseDTO> badgeResponseDTOS) {
        return BadgesResponseDTO.builder()
                .badges(badgeResponseDTOS)
                .build();
    }
}
