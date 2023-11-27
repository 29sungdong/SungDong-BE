package sungdong29.backend.domain.walk.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.domain.Walk;
import sungdong29.backend.domain.walk.repository.WalkRepository;
import sungdong29.backend.global.config.user.UserDetails;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalkService {
    private final WalkRepository walkRepository;
    private final PlaceRepository placeRepository;

    @Transactional
    public void createWalkRecord(UserDetails userDetails, Long placeId) {
        User user = userDetails.getUser();
        Place place = placeRepository.findById(placeId).orElseThrow();

        Walk walk = Walk.of(user, place);
        walkRepository.save(walk);
    }
}
