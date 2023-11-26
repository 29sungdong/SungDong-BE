package sungdong29.backend.domain.mission.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class MissionsResponseDTO {
    List<MissionResponseDTO> missions;
}
