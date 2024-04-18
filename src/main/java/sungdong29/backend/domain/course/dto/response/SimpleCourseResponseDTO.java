package sungdong29.backend.domain.course.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.domain.Course;

@Getter
public class SimpleCourseResponseDTO {

    private Long id;

    private String name;

    private String preview;

    private String image;

    private Long likeCount;

    @Builder
    private SimpleCourseResponseDTO(Long id, String name, String preview, String image, Long likeCount) {
        this.id = id;
        this.name = name;
        this.preview = preview;
        this.image = image;
        this.likeCount = likeCount;
    }

    public static SimpleCourseResponseDTO of(Course course, String preview, Long likeCount) {
        return SimpleCourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .preview(preview)
                .image(course.getImage())
                .likeCount(likeCount)
                .build();
    }
}
