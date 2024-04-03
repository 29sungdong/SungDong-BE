package sungdong29.backend.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.place.domain.PlaceLike;

public interface PlaceLikeRepository extends JpaRepository<PlaceLike, Long> {

    Long countByPlace(Place place);
}
