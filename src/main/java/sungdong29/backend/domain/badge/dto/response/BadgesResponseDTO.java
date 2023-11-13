package sungdong29.backend.domain.badge.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BadgesResponseDTO {
    private List<GroupedBadgeDTO> groupedBadges;

    public static BadgesResponseDTO from(List<BadgeResponseDTO> badgeResponseDTOS) {
        BadgesResponseDTO responseDTO = new BadgesResponseDTO();
        responseDTO.groupedBadges = groupBadgesByCategory(badgeResponseDTOS);
        return responseDTO;
    }

    private static List<GroupedBadgeDTO> groupBadgesByCategory(List<BadgeResponseDTO> badgeResponseDTOS) {
        return badgeResponseDTOS.stream()
                .collect(Collectors.groupingBy(BadgeResponseDTO::getCategory))
                .entrySet()
                .stream()
                .map(category -> new GroupedBadgeDTO(category.getKey(), category.getValue()))
                .collect(Collectors.toList());
    }
}
