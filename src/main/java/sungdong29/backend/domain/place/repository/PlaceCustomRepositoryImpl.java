package sungdong29.backend.domain.place.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.domain.QPlace;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlaceCustomRepositoryImpl implements PlaceCustomRepository {

    private final JPAQueryFactory queryFactory;

    QPlace qPlace = QPlace.place;

    @Override
    public List<Place> findByFilter(Category category, String keyword) {

        return queryFactory.selectFrom(qPlace)
                .where(eqCategory(category))
                .where(containsKeyword(keyword))
                .fetch();
    }

    private BooleanExpression eqCategory(Category category) {
        if (category == null) {
            return null;
        }

        return qPlace.category.eq(category);
    }

    private BooleanExpression containsKeyword(String keyword) {
        if (keyword == null) {
            return null;
        }

        return qPlace.name.contains(keyword);
    }
}
