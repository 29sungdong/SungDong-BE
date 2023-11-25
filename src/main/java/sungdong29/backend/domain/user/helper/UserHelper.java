package sungdong29.backend.domain.user.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.repository.PlaceRepository;
import sungdong29.backend.domain.subPlace.repository.MissionRepository;
import sungdong29.backend.domain.subPlace.repository.UserMissionRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.domain.walk.repository.WalkRepository;

@Component
@RequiredArgsConstructor
public class UserHelper {

    private final WalkRepository walkRepository;
    private final PlaceRepository placeRepository;
    private final UserMissionRepository userMissionRepository;
    private final MissionRepository missionRepository;

    public int calcPlacePercent(User user) {
        Long placeNum = walkRepository.countByUser(user);
        long totalPlace = placeRepository.count();

        return (int) ((double)placeNum / totalPlace * 100);
    }

    public int calcMissionPercent(User user) {
        Long missionNum = userMissionRepository.countByUser(user);
        long totalMission = missionRepository.count();

        return (int) ((double) missionNum / totalMission * 100);
    }
}
