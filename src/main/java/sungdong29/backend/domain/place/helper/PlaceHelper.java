package sungdong29.backend.domain.place.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.exception.PlaceNotFound;
import sungdong29.backend.domain.place.repository.PlaceRepository;


@Component
@RequiredArgsConstructor
public class PlaceHelper {

    private final PlaceRepository placeRepository;

    public Place getPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> {
            throw PlaceNotFound.EXCEPTION;
        });
    }
}
