package sungdong29.backend.domain.course.dto.request;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.domain.Category;

import java.util.List;

@Getter
public class CourseInfoRequestDTO {

    private String title;

    private Category category;

    private String description;

    private List<Long> coursePlaceIds;

    @Builder
    private CourseInfoRequestDTO(String title, Category category, String description, List<Long> coursePlaceIds) {
        this.title = title;
        this.category = category;
        this.description = description;
        this.coursePlaceIds = coursePlaceIds;
    }
}