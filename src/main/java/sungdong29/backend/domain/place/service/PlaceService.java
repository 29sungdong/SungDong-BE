package sungdong29.backend.domain.place.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.dto.response.PlaceResponseDTO;
import sungdong29.backend.domain.place.dto.response.PlaceCardListResponseDTO;
import sungdong29.backend.domain.place.mapper.PlaceMapper;
import sungdong29.backend.domain.place.dto.response.PlaceBoardListResponseDTO;
import sungdong29.backend.domain.place.helper.PlaceHelper;
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
    public PlaceBoardListResponseDTO getBoardList(String xCoordinate, String yCoordinate) {
        List<Place> places = placeRepository.findAllByDistanceAsc(xCoordinate, yCoordinate);
        return placeMapper.toBoardListDTO(places);
    }

    @Transactional(readOnly = true)
    public PlaceCardListResponseDTO getCardList(String xCoordinate, String yCoordinate) {
        List<Place> places = placeRepository.findAllByDistanceAsc(xCoordinate, yCoordinate);
        return placeMapper.toCardListDTO(places);
    }

    @Transactional(readOnly = true)
    public PlaceResponseDTO getPlaceById(Long id) {
        Place place = placeHelper.getPlaceById(id);
        return placeMapper.toPlaceDTO(place);
    }
}
