package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

@Getter
public class WalkPathResponseDTO {

    private Long id;
    private String name;
    private List<String> lineString;

    @Builder
    private WalkPathResponseDTO(
            Long id,
            String name,
            List<String> lineString) {
        this.id = id;
        this.name = name;
        this.lineString = lineString;
    }

    public static WalkPathResponseDTO of(Walk walk, List<String> lineString) {
        return WalkPathResponseDTO.builder()
                .id(walk.getId())
                .name(walk.getName())
                .lineString(lineString)
                .build();
    }
}
