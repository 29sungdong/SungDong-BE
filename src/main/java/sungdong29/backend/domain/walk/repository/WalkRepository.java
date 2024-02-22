package sungdong29.backend.domain.walk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

public interface WalkRepository extends JpaRepository<Walk, Long> {
    @Query("SELECT w FROM Walk w ORDER BY " +
            "ST_DISTANCE(POINT(w.xCoordinate, w.yCoordinate), POINT(:x, :y)) + " +
            "ST_DISTANCE(POINT(w.xCoordinate, w.yCoordinate), POINT(:pX, :pY)) ASC")
    List<Walk> findAllByDistanceAsc(@Param("x") String x, @Param("y") String y, @Param("pX") String pX, @Param("pY") String pY);


    @Query("SELECT w FROM Walk w ORDER BY " +
            "ST_DISTANCE(POINT(w.xCoordinate, w.yCoordinate), POINT(:x, :y)) + " +
            "ST_DISTANCE(POINT(w.xCoordinate, w.yCoordinate), POINT(:pX, :pY)) ASC")
    Walk findClosestWalk(@Param("x") String x, @Param("y") String y, @Param("pX") String pX, @Param("pY") String pY);

}
