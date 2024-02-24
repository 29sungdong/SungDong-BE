package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

@Getter
public class WalkPathResponseDTO {

    private Long id;
    private String name;
    private double xCoordinate;
    private double yCoordinate;
    private int totalDistance;
    private int totalTime;
    private List<List<Double>> coordinates;

    @Builder
    private WalkPathResponseDTO(
            Long id,
            String name,
            double xCoordinate,
            double yCoordinate,
            int totalTime,
            int totalDistance,
            List<List<Double>> coordinates) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.coordinates = coordinates;
    }

    public static WalkPathResponseDTO of(Walk walk, TmapPathResponseDTO path) {
        return WalkPathResponseDTO.builder()
                .id(walk.getId())
                .name(walk.getName())
                .xCoordinate(walk.getXCoordinate())
                .yCoordinate(walk.getYCoordinate())
                .totalTime(path.getTotalTime())
                .totalDistance(path.getTotalDistance())
                .coordinates(path.getCoordinates())
                .build();
    }
}
