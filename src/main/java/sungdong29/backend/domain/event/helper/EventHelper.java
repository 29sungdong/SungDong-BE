package sungdong29.backend.domain.event.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.enums.SortCategoryType;
import sungdong29.backend.domain.event.exception.EventNotFound;
import sungdong29.backend.domain.event.repository.EventRepository;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class EventHelper {

    private final EventRepository eventRepository;

    public List<Event> getEventList(List<SortCategoryType> sortCategoryList, Long placeId) {
        List<Event> events;

        if (sortCategoryList == null || sortCategoryList.isEmpty()) {
            events = eventRepository.findByFilter(null, placeId);
        }
        else {
            List<Category> categoryList = toCategoryList(sortCategoryList);
            events = eventRepository.findByFilter(categoryList, placeId);
        }

        if (events == null || events.isEmpty()) {
            throw EventNotFound.EXCEPTION;
        }

        return events;
    }
    
    private List<Category> toCategoryList(List<SortCategoryType> sortType) {
        List<Category> categories = new ArrayList<>();

        for (SortCategoryType type : sortType) {
            switch (type) {
                case EDUCATION -> categories.add(Category.EDUCATION);
                case FARM -> categories.add(Category.FARM);
                case CULTURE -> categories.add(Category.CULTURE);
                case EXHIBITION -> categories.add(Category.EXHIBITION);
                case VOLUNTEER -> categories.add(Category.VOLUNTEER);
                case PARK -> categories.add(Category.PARK);
                case FOREST -> categories.add(Category.FOREST);
            }
        }

        return categories;
    }
}
