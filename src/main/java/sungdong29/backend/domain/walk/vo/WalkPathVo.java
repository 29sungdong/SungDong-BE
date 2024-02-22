package sungdong29.backend.domain.walk.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sungdong29.backend.domain.walk.domain.Walk;

import java.util.List;

@Getter
@NoArgsConstructor
public class WalkPathVo {

    private Long id;
    private String name;
    private List<String> lineString;

    @Builder
    private WalkPathVo(
            Long id,
            String name,
            List<String> lineString) {
        this.id = id;
        this.name = name;
        this.lineString = lineString;
    }

    public static WalkPathVo of(Walk walk, List<String> lineString) {
        return WalkPathVo.builder()
                .id(walk.getId())
                .name(walk.getName())
                .lineString(lineString)
                .build();
    }
}
