package sungdong29.backend.domain.place.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.MarkerListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceListResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.helper.PlaceHelper;
import sungdong29.backend.domain.place.mapper.PlaceMapper;
import sungdong29.backend.domain.place.repository.PlaceRepository;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlaceService {

    private final PlaceRepository placeRepository;
    private final PlaceMapper placeMapper;
    private final PlaceHelper placeHelper;

    @Transactional(readOnly = true)
    public PlaceListResponseDTO getPlaceList(String xCoordinate, String yCoordinate) {
        List<Place> places = placeRepository.findAllByDistanceAsc(xCoordinate, yCoordinate);
        return placeMapper.toCardListDTO(places);
    }

    @Transactional(readOnly = true)
    public PlaceResponseDTO getPlaceById(Long id) {
        Place place = placeHelper.getPlaceById(id);
        return placeMapper.toPlaceDTO(place);
    }

    @Transactional(readOnly = true)
    public MarkerListResponseDTO getPlaceByKeyword(String keyword) {
        List<Place> places = placeRepository.findByNameContaining(keyword);
        return placeMapper.toMarkerListDTO(places);
    }

    @Transactional(readOnly = true)
    public MarkerListResponseDTO getMarkerList(String xCoordinate, String yCoordinate, int limit) {
        List<Place> places = placeRepository.findAllByDistanceAscWithLimit(xCoordinate, yCoordinate, limit);
        return placeMapper.toMarkerListDTO(places);
    }
}
