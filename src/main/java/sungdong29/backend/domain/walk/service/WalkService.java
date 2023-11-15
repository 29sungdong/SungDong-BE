package sungdong29.backend.domain.walk.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.badge.domain.Badge;
import sungdong29.backend.domain.badge.domain.UserBadge;
import sungdong29.backend.domain.badge.repository.BadgeRepository;
import sungdong29.backend.domain.badge.repository.UserBadgeRepository;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.user.repository.UserRepository;
import sungdong29.backend.domain.walk.domain.Walk;
import sungdong29.backend.domain.walk.dto.request.WalkRecordRequestDTO;
import sungdong29.backend.domain.walk.dto.response.WalkBadgeResponseDTO;
import sungdong29.backend.domain.walk.exception.BadgeNotFound;
import sungdong29.backend.domain.walk.repository.WalkRepository;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalkService {
    private final WalkRepository walkRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
    private final BadgeRepository badgeRepository;
    private final UserBadgeRepository userBadgeRepository;

    public UserBadge findOrCreatePlaceBadge(Place place, User user) {
        Badge badge = badgeRepository.findByCategory(place.getCategory().getCategory()).orElseThrow(()-> BadgeNotFound.EXCEPTION);

        UserBadge userBadge = userBadgeRepository.findByUserAndName(user, place.getName())
                .orElseGet(() -> userBadgeRepository.save(UserBadge.of(user, badge, place.getName())));

        return userBadge;
    }

    @Transactional
    public WalkBadgeResponseDTO createWalkRecord(Long userId, Long placeId, WalkRecordRequestDTO walkRecordRequestDTO) {
        User user = userRepository.findById(userId).orElseThrow();
        Place place = placeRepository.findById(placeId).orElseThrow();

        Walk walk = Walk.of(user, place, walkRecordRequestDTO.getSteps());
        walkRepository.save(walk);

        UserBadge userBadge = findOrCreatePlaceBadge(place, user);

        return WalkBadgeResponseDTO.from(userBadge);
    }
}
