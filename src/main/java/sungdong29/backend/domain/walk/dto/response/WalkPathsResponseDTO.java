package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class WalkPathsResponseDTO {

    private List<WalkPathResponseDTO> paths;

    @Builder
    private WalkPathsResponseDTO(List<WalkPathResponseDTO> paths) {
        this.paths = paths;
    }

    public static WalkPathsResponseDTO from(List<WalkPathResponseDTO> paths) {
        return WalkPathsResponseDTO.builder()
                .paths(paths)
                .build();
    }
}
