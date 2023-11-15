package sungdong29.backend.domain.badge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class UserBadgeResponseDTO {
    private Long id;
    private String category;
    private String imageUrl;
    private List<BadgeResponseDTO> badges;
}
