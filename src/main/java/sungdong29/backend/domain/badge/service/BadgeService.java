package sungdong29.backend.domain.badge.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.badge.domain.UserBadge;
import sungdong29.backend.domain.badge.dto.response.BadgeResponseDTO;
import sungdong29.backend.domain.badge.dto.response.BadgesResponseDTO;
import sungdong29.backend.domain.badge.repository.BadgeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BadgeService {
    private final BadgeRepository badgeRepository;
    private final ModelMapper mapper;

    public BadgesResponseDTO findUserBadges(Long userId) {
        List<UserBadge> userBadges = badgeRepository.findByUserIdAndIsAchievedTrue(userId);
        List<BadgeResponseDTO> badgeResponseDTOS = userBadges
                .stream()
                .map(userBadge -> mapper.map(userBadge.getBadge(), BadgeResponseDTO.class))
                .collect(Collectors.toList());

        return BadgesResponseDTO.from(badgeResponseDTOS);
    }
}
