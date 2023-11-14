package sungdong29.backend.domain.event.repository;

import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.domain.Event;

import java.util.List;

public interface EventCustomRepository {
    List<Event> findByFilter(List<Category> categoryList, Long placeId);
}
