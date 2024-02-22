package sungdong29.backend.domain.walk.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.helper.PlaceHelper;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.domain.Walk;
import sungdong29.backend.domain.walk.domain.WalkHistory;
import sungdong29.backend.domain.walk.dto.response.WalkPathResponseDTO;
import sungdong29.backend.domain.walk.helper.WalkHelper;
import sungdong29.backend.domain.walk.repository.WalkHistoryRepository;
import sungdong29.backend.domain.walk.repository.WalkRepository;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class WalkService {
    private final WalkRepository walkRepository;
    private final WalkHistoryRepository walkHistoryRepository;
    private final PlaceRepository placeRepository;
    private final PlaceHelper placeHelper;
    private final WalkHelper walkHelper;

    @Transactional
    public WalkPathResponseDTO getWalkPath(String xCoordinate, String yCoordinate, Long placeId) {
        Place place = placeHelper.getPlaceById(placeId);

        // List<Walk> walks = walkRepository.findAllByDistanceAsc(xCoordinate, yCoordinate, place.getXCoordinate(), place.getYCoordinate());
        Walk walk = walkRepository.findClosestWalk(xCoordinate, yCoordinate, place.getXCoordinate(), place.getYCoordinate());

        List<String> lineString = walkHelper.getLineString(xCoordinate, yCoordinate, place, walk);
        return WalkPathResponseDTO.of(walk, lineString);
    }

    @Transactional
    public void createWalkRecord(UserDetails userDetails, Long placeId) {
        User user = userDetails.getUser();
        Place place = placeRepository.findById(placeId).orElseThrow();

        WalkHistory walkHistory = WalkHistory.of(user, place);
        walkHistoryRepository.save(walkHistory);
    }
}
