package sungdong29.backend.domain.walk.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.helper.PlaceHelper;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.domain.Walk;
import sungdong29.backend.domain.walk.domain.WalkHistory;
import sungdong29.backend.domain.walk.dto.response.ShortestPathResponseDTO;
import sungdong29.backend.domain.walk.dto.response.WalkPathResponseDTO;
import sungdong29.backend.domain.walk.dto.response.WalkPathsResponseDTO;
import sungdong29.backend.domain.walk.helper.WalkHelper;
import sungdong29.backend.domain.walk.repository.WalkHistoryRepository;
import sungdong29.backend.domain.walk.repository.WalkRepository;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.ArrayList;
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
    public ShortestPathResponseDTO getShortestPath(String startX, String startY, Long placeId) {
        Place place = placeHelper.getPlaceById(placeId);
        List<List<Double>> lineString = walkHelper.getLineString(startX, startY, place, 0, 0);
        return ShortestPathResponseDTO.from(lineString);
    }

    @Transactional
    public WalkPathsResponseDTO getWalkPath(String startX, String startY, Long placeId) {
        List<WalkPathResponseDTO> paths = new ArrayList<>();
        Place place = placeHelper.getPlaceById(placeId);

        PageRequest pageable = PageRequest.of(0, 3);
        Page<Walk> closeWalks = walkRepository.findClosestWalk(startX, startY, place.getXCoordinate(), place.getYCoordinate(), pageable);

        for (Walk walk : closeWalks.getContent()) {
            List<List<Double>> lineString = walkHelper.getLineString(startX, startY, place, walk.getXCoordinate(), walk.getYCoordinate());
            paths.add(WalkPathResponseDTO.of(walk, lineString));

        }
        return WalkPathsResponseDTO.from(paths);
    }

    @Transactional
    public void createWalkRecord(UserDetails userDetails, Long placeId) {
        User user = userDetails.getUser();
        Place place = placeRepository.findById(placeId).orElseThrow();

        WalkHistory walkHistory = WalkHistory.of(user, place);
        walkHistoryRepository.save(walkHistory);
    }
}
