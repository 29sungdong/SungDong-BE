package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

@Getter
public class ShortestPathResponseDTO {

    private int totalDistance;
    private int totalTime;
    private List<List<Double>> coordinates;

    @Builder
    private ShortestPathResponseDTO(
            List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }

    public static ShortestPathResponseDTO from(List<List<Double>> coordinates) {
        return ShortestPathResponseDTO.builder()
                .coordinates(coordinates)
                .build();
    }
}
