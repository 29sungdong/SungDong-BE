package sungdong29.backend.domain.subPlace.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.subPlace.domain.Mission;
import sungdong29.backend.domain.subPlace.domain.SubPlace;
import sungdong29.backend.domain.subPlace.domain.UserMission;
import sungdong29.backend.domain.subPlace.dto.response.MissionResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlaceResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlacesResponseDTO;
import sungdong29.backend.domain.subPlace.exception.SubPlaceNotFound;
import sungdong29.backend.domain.subPlace.helper.MissionHelper;
import sungdong29.backend.domain.subPlace.repository.SubPlaceRepository;
import sungdong29.backend.domain.subPlace.repository.UserMissionRepository;
import sungdong29.backend.domain.user.domain.User;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubPlaceService {

    private final MissionHelper missionHelper;
    private final SubPlaceRepository subPlaceRepository;
    private final UserMissionRepository userMissionRepository;
    private final ModelMapper mapper;

    public SubPlacesResponseDTO findSubPlaces(Long placeId) {
        List<SubPlace> subPlaces = subPlaceRepository.findByPlaceId(placeId);
        List<SubPlaceResponseDTO> subPlaceResponseDTOS = subPlaces
                .stream()
                .map(subPlace -> mapper.map(subPlace, SubPlaceResponseDTO.class))
                .collect(Collectors.toList());
        return new SubPlacesResponseDTO(subPlaceResponseDTOS);
    }

    public MissionsResponseDTO findMissionsBySubPlaceId(Long subPlaceId) {
        SubPlace subPlace = subPlaceRepository.findById(subPlaceId).orElseThrow(()-> SubPlaceNotFound.EXCEPTION);
        List<Mission> missions = subPlace.getMissions();
        List<MissionResponseDTO> missionResponseDTOS = missions
                .stream()
                .map(mission -> mapper.map(mission, MissionResponseDTO.class))
                .collect(Collectors.toList());
        return new MissionsResponseDTO(missionResponseDTOS);
    }

    public void accomplishMission(UserDetails userDetails,  Long subPlaceId, Long missionId) {
        final User user = userDetails.getUser();
        Mission mission = missionHelper.findMission(missionId);
        UserMission userMission = UserMission.of(user, mission);
        userMissionRepository.save(userMission);
    }
}
