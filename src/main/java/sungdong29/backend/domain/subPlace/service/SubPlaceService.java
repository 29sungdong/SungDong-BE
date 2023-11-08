package sungdong29.backend.domain.subPlace.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import sungdong29.backend.domain.subPlace.domain.SubPlace;
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

    public SubPlacesResponseDTO findSubPlaces(Long place_id) {
        List<SubPlace> subPlaces = subPlaceRepository.findByPlaceId(place_id);
        List<SubPlaceResponseDTO> subPlaceResponseDTOS = subPlaces
                .stream()
                .map(user -> mapper.map(user, SubPlaceResponseDTO.class))
                .collect(Collectors.toList());
        return new SubPlacesResponseDTO(subPlaceResponseDTOS);
    }
}
