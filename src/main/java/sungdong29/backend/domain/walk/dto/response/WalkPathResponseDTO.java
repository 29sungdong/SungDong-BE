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
            List<List<Double>> coordinates) {
        this.id = id;
        this.name = name;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.coordinates = coordinates;
    }

    public static WalkPathResponseDTO of(Walk walk, List<List<Double>> coordinates) {
        return WalkPathResponseDTO.builder()
                .id(walk.getId())
                .name(walk.getName())
                .xCoordinate(walk.getXCoordinate())
                .yCoordinate(walk.getYCoordinate())
                .coordinates(coordinates)
                .build();
    }
}
