package sungdong29.backend.domain.walk.dto.response;

import lombok.Builder;
import sungdong29.backend.domain.walk.vo.WalkPathVo;

import java.util.List;

public class WalkPathListResponseDTO {

    List<WalkPathVo> walkPathList;

    @Builder
    private WalkPathListResponseDTO(List<WalkPathVo> walkPathList) {
        this.walkPathList = walkPathList;
    }

    public static WalkPathListResponseDTO from(List<WalkPathVo> walkPathList) {
        return WalkPathListResponseDTO.builder()
                .walkPathList(walkPathList)
                .build();
    }
}
