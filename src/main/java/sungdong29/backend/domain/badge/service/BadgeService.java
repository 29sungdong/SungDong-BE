package sungdong29.backend.domain.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.badge.domain.UserBadge;
import sungdong29.backend.domain.badge.dto.response.BadgeResponseDTO;
import sungdong29.backend.domain.badge.dto.response.BadgesResponseDTO;
import sungdong29.backend.domain.badge.dto.response.UserBadgeResponseDTO;
import sungdong29.backend.domain.badge.repository.UserBadgeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BadgeService {
    private final UserBadgeRepository userBadgeRepository;

    public BadgesResponseDTO findUserBadges(Long userId) {
        List<UserBadge> userBadges = userBadgeRepository.findByUserId(userId);
        List<BadgeResponseDTO> badgeResponseDTOS = userBadges
                .stream()
                .collect(Collectors.groupingBy(UserBadge::getBadge))
                .entrySet().stream()
                .map(entry -> BadgeResponseDTO.of(entry.getKey(),
                        entry.getValue().stream()
                                .map(UserBadgeResponseDTO::from)
                                .collect(Collectors.toList())))
                .collect(Collectors.toList());

        return BadgesResponseDTO.from(badgeResponseDTOS);
    }
}
