package sungdong29.backend.domain.event.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.event.vo.CalenderVo;

import java.util.List;

@Getter
public class CalenderResponseDTO {
    List<CalenderVo> data;

    @Builder
    private CalenderResponseDTO(List<CalenderVo> data) {
        this.data = data;
    }

    public static CalenderResponseDTO from(List<CalenderVo> data) {
        return CalenderResponseDTO.builder()
                .data(data)
                .build();
    }
}
