package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TmapPathResponseDTO {

    private int totalDistance;
    private int totalTime;
    private List<List<Double>> coordinates;

    @Builder
    private TmapPathResponseDTO(
            int totalDistance,
            int totalTime,
            List<List<Double>> coordinates) {
        this.totalDistance = totalDistance;
        this.totalTime = totalTime;
        this.coordinates = coordinates;
    }

    public static TmapPathResponseDTO of(
            int totalDistance,
            int totalTime,
            List<List<Double>> coordinates) {
        return TmapPathResponseDTO.builder()
                .totalDistance(totalDistance)
                .totalTime(totalTime)
                .coordinates(coordinates)
                .build();
    }
}
