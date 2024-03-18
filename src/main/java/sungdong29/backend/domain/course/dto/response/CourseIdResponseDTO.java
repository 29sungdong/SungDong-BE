package sungdong29.backend.domain.course.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseIdResponseDTO {

    private Long id;

    @Builder
    private CourseIdResponseDTO(Long id) {
        this.id = id;
    }

    public static CourseIdResponseDTO from(Long id) {
        return CourseIdResponseDTO.builder()
                .id(id)
                .build();
    }
}
