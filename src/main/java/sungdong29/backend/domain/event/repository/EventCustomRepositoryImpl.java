package sungdong29.backend.domain.event.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.domain.Event;
import sungdong29.backend.domain.event.domain.QEvent;
import sungdong29.backend.domain.place.domain.QPlace;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventCustomRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    QPlace qPlace = QPlace.place;

    QEvent qEvent = QEvent.event;

    @Override
    public List<Event> findByFilter(List<Category> categoryList, Long placeId) {
        LocalDateTime now = LocalDateTime.now();

        return queryFactory.selectFrom(qEvent)
                .leftJoin(qEvent.place, qPlace).fetchJoin()        // Fetch join for Place
                .where(eqCategory(categoryList))
                .where(eqPlaceId(placeId))
                .where(qEvent.endDateTime.after(now))
                .fetch();
    }

    private BooleanExpression eqCategory(List<Category> categoryList) {
        if (categoryList == null || categoryList.isEmpty()) {
            return null;
        }

        return categoryList.stream()
                .map(cat -> qEvent.category.eq(cat))
                .reduce(BooleanExpression::or)
                .orElse(null);
    }

    private BooleanExpression eqPlaceId(Long placeId) {
        return placeId == null ? null : qEvent.place.id.eq(placeId);
    }
}
