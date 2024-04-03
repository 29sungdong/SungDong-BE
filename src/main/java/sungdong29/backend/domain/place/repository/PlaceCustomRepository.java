package sungdong29.backend.domain.place.repository;

import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

public interface PlaceCustomRepository {
    List<Place> findByFilter(Category category, String keyword);
}
