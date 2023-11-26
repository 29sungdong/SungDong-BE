package sungdong29.backend.domain.mission.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.mission.domain.Mission;
import sungdong29.backend.domain.mission.exception.MissionNotFound;
import sungdong29.backend.domain.mission.repository.MissionRepository;

@Component
@RequiredArgsConstructor
public class MissionHelper {

    private final MissionRepository missionRepository;

    public Mission findUser(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> MissionNotFound.EXCEPTION);
    }

    public Mission findMission(Long missionId) {
        return missionRepository.findById(missionId)
                .orElseThrow(() -> MissionNotFound.EXCEPTION);
    }
}
