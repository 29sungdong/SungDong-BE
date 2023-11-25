package sungdong29.backend.domain.user.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class StatsResponseDTO {

    private int placePercent;
    private int missionPercent;

    @Builder
    private StatsResponseDTO(int placePercent, int missionPercent) {
        this.placePercent = placePercent;
        this.missionPercent = missionPercent;
    }

    public static StatsResponseDTO of(int placePercent, int missionPercent) {
        return StatsResponseDTO.builder()
                .placePercent(placePercent)
                .missionPercent(missionPercent)
                .build();
    }
}
