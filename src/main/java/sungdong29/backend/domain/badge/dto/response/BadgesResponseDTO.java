package sungdong29.backend.domain.badge.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BadgesResponseDTO {
    List<BadgeResponseDTO> badges;

    private BadgesResponseDTO(List<BadgeResponseDTO> badges) {
        this.badges = badges;
    }

    public static BadgesResponseDTO from(List<BadgeResponseDTO> badges) {
        return new BadgesResponseDTO(badges);
    }
}
