package sungdong29.backend.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    @Query("SELECT p FROM Place p ORDER BY ST_DISTANCE(POINT(p.xCoordinate, p.yCoordinate), POINT(:x, :y)) ASC")
    List<Place> findAllByDistanceAsc(@Param("x") String x, @Param("y") String y);

    List<Place> findByNameContaining(String keyword);
}
