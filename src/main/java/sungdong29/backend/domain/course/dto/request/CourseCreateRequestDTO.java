package sungdong29.backend.domain.course.dto.request;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.domain.Category;

import java.time.LocalDate;
import java.util.List;

@Getter
public class CourseCreateRequestDTO {

    private String title;

    private LocalDate date;

    private String description;

    private String image;

    private List<Category> categoryList;

    private List<Long> placeIds;

    private Boolean isSungDongSelected;

    private Boolean isSungDongRecommended;

    @Builder
    private CourseCreateRequestDTO(String title, LocalDate date, String description, String image, List<Category> categoryList, List<Long> placeIds, Boolean isSungDongSelected, Boolean isSungDongRecommended) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.image = image;
        this.categoryList = categoryList;
        this.placeIds = placeIds;
        this.isSungDongSelected = isSungDongSelected;
        this.isSungDongRecommended = isSungDongRecommended;
    }
}