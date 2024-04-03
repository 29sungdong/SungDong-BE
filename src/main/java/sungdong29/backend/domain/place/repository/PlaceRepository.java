package sungdong29.backend.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sungdong29.backend.domain.place.domain.Category;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Long>, PlaceCustomRepository {

    @Query("SELECT p FROM Place p ORDER BY ST_DISTANCE(POINT(p.xCoordinate, p.yCoordinate), POINT(:x, :y)) ASC")
    List<Place> findAllByDistanceAsc(@Param("x") String x, @Param("y") String y);

    @Query(value = "SELECT * FROM place p ORDER BY ST_DISTANCE(POINT(p.x_coordinate, p.y_coordinate), POINT(:x, :y)) ASC LIMIT :limit", nativeQuery = true)
    List<Place> findByDistanceAscWithLimit(@Param("x") String x, @Param("y") String y, @Param("limit") int limit);

    @Query(value = "SELECT * FROM place p WHERE p.place_id != :placeId ORDER BY ST_DISTANCE(POINT(p.x_coordinate, p.y_coordinate), POINT(:x, :y)) ASC LIMIT :limit", nativeQuery = true)
    List<Place> findByDistanceAscWithLimitExceptMe(@Param("x") String x, @Param("y") String y, @Param("placeId") Long placeId, @Param("limit") int limit);

    List<Place> findByNameContaining(String keyword);

    List<Place> findAllByCategory(Category category);
}
