package sungdong29.backend.domain.mission.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MissionsResponseDTO {
    List<MissionResponseDTO> missions;

    @Builder
    private MissionsResponseDTO(List<MissionResponseDTO> missions) { this.missions=missions; };

    public static MissionsResponseDTO from(List<MissionResponseDTO> missions) {
        return MissionsResponseDTO.builder()
                .missions(missions)
                .build();
    }
}
