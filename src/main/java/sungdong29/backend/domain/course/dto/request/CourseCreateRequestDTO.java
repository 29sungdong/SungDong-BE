package sungdong29.backend.domain.course.dto.request;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.domain.Category;

import java.util.List;

@Getter
public class CourseCreateRequestDTO {

    private String title;

    private Category category;

    private String description;

    private List<Long> placeIds;

    @Builder
    private CourseCreateRequestDTO(String title, Category category, String description, List<Long> placeIds) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.placeIds = placeIds;
    }
}