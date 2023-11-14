package sungdong29.backend.domain.place.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.place.vo.MarkerVo;

import java.util.List;

@Getter
public class MarkerListResponseDTO {

    List<MarkerVo> markers;

    @Builder
    private MarkerListResponseDTO(List<MarkerVo> markers) { this.markers = markers; }

    public static MarkerListResponseDTO from(List<MarkerVo> markers) {
        return MarkerListResponseDTO.builder()
                .markers(markers)
                .build();
    }
}
