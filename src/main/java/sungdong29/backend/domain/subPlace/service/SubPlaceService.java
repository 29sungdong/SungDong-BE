package sungdong29.backend.domain.subPlace.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.subPlace.domain.Mission;
import sungdong29.backend.domain.subPlace.domain.SubPlace;
import sungdong29.backend.domain.subPlace.dto.response.MissionResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.MissionsResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlaceResponseDTO;
import sungdong29.backend.domain.subPlace.dto.response.SubPlacesResponseDTO;
import sungdong29.backend.domain.subPlace.repository.SubPlaceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubPlaceService {
    private final SubPlaceRepository subPlaceRepository;
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
        SubPlace subPlace = subPlaceRepository.findById(subPlaceId).orElseThrow();
        List<Mission> missions = subPlace.getMissions();
        List<MissionResponseDTO> missionResponseDTOS = missions
                .stream()
                .map(mission -> mapper.map(mission, MissionResponseDTO.class))
                .collect(Collectors.toList());
        return new MissionsResponseDTO(missionResponseDTOS);
    }
}
