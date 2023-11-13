package sungdong29.backend.domain.badge.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GroupedBadgeDTO {
    private String category;
    private List<BadgeResponseDTO> badges;
}
