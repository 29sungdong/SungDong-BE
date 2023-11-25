package sungdong29.backend.domain.badge.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.badge.domain.Badge;
import sungdong29.backend.domain.badge.domain.Category;
import sungdong29.backend.domain.badge.domain.UserBadge;
import sungdong29.backend.domain.badge.dto.response.BadgeResponseDTO;
import sungdong29.backend.domain.badge.dto.response.BadgesResponseDTO;
import sungdong29.backend.domain.badge.dto.response.UserBadgeResponseDTO;
import sungdong29.backend.domain.badge.repository.BadgeRepository;
import sungdong29.backend.domain.badge.repository.UserBadgeRepository;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.exception.BadgeNotFound;

import java.util.List;
import java.util.stream.Collectors;

import static sungdong29.backend.domain.badge.domain.Category.PLACE;

@Service
@RequiredArgsConstructor
public class BadgeService {
    private final UserBadgeRepository userBadgeRepository;
    private final BadgeRepository badgeRepository;

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

    public void createBadge(Category category, User user, String name) {
        Badge badge = badgeRepository.findByCategory(category).orElseThrow();
        UserBadge userBadge = UserBadge.of(user, badge, name);
        userBadgeRepository.save(userBadge);
    }

    public UserBadge findOrCreatePlaceBadge(Place place, User user) {
        Badge badge = badgeRepository.findByCategory(PLACE).orElseThrow(()-> BadgeNotFound.EXCEPTION);
        UserBadge userBadge = userBadgeRepository.findByUserAndName(user, place.getName())
                .orElseGet(() -> userBadgeRepository.save(UserBadge.of(user, badge, place.getName())));

        return userBadge;
    }

}
