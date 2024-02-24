package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

@Getter
public class ShortestPathResponseDTO {

    private int totalTime;
    private int totalDistance;
    private List<List<Double>> coordinates;

    @Builder
    private ShortestPathResponseDTO(
            int totalTime,
            int totalDistance,
            List<List<Double>> coordinates) {
        this.totalTime = totalTime;
        this.totalDistance = totalDistance;
        this.coordinates = coordinates;
    }

    public static ShortestPathResponseDTO from(TmapPathResponseDTO path) {
        return ShortestPathResponseDTO.builder()
                .totalTime(path.getTotalTime())
                .totalDistance(path.getTotalDistance())
                .coordinates(path.getCoordinates())
                .build();
    }
}
