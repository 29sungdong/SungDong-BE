package sungdong29.backend.domain.mission.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.mission.domain.Mission;
import sungdong29.backend.domain.mission.domain.UserMission;
import sungdong29.backend.domain.mission.dto.response.MissionResponseDTO;
import sungdong29.backend.domain.mission.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.mission.helper.MissionHelper;
import sungdong29.backend.domain.mission.repository.UserMissionRepository;
import sungdong29.backend.domain.subPlace.domain.SubPlace;
import sungdong29.backend.domain.subPlace.exception.SubPlaceNotFound;
import sungdong29.backend.domain.subPlace.repository.SubPlaceRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class  MissionService {

    private final MissionHelper missionHelper;
    private final SubPlaceRepository subPlaceRepository;
    private final UserMissionRepository userMissionRepository;
    private final ModelMapper mapper;

    public MissionsResponseDTO findMissionsBySubPlaceId(Long subPlaceId) {
        SubPlace subPlace = subPlaceRepository.findById(subPlaceId).orElseThrow(()-> SubPlaceNotFound.EXCEPTION);
        List<Mission> missions = subPlace.getMissions();
        List<MissionResponseDTO> missionResponseDTOS = missions
                .stream()
                .map(mission -> mapper.map(mission, MissionResponseDTO.class))
                .collect(Collectors.toList());
        return MissionsResponseDTO.from(missionResponseDTOS);
    }

    public void accomplishMission(UserDetails userDetails, Long missionId) {
        final User user = userDetails.getUser();
        Mission mission = missionHelper.findMission(missionId);
        UserMission userMission = UserMission.of(user, mission);
        userMissionRepository.save(userMission);
    }
}
