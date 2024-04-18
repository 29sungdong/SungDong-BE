package sungdong29.backend.domain.course.dto.response;

import lombok.Builder;
import lombok.Getter;
import sungdong29.backend.domain.course.domain.Course;
import sungdong29.backend.domain.course.domain.Category;
import sungdong29.backend.domain.place.dto.response.SimplePlaceResponseDTO;

import java.util.List;

@Getter
public class CourseResponseDTO {

    private Long id;

    private String name;

    private String preview;

    private String description;

    private String image;

    private Long likeCount;

    private Category category1;

    private Category category2;

    private Category category3;

    private Boolean byService;

    private Boolean byResidents;

    private List<SimplePlaceResponseDTO> placeList;

    @Builder
    private CourseResponseDTO(Long id, String name, String preview, String description, String image, Long likeCount, Category category1, Category category2, Category category3, Boolean byService, Boolean byResidents, List<SimplePlaceResponseDTO> placeList) {
        this.id = id;
        this.name = name;
        this.preview = preview;
        this.description = description;
        this.image = image;
        this.likeCount = likeCount;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.byService = byService;
        this.byResidents = byResidents;
        this.placeList = placeList;
    }

    public static CourseResponseDTO of(Course course, String preview, Long likeCount, List<SimplePlaceResponseDTO> placeList) {
        return CourseResponseDTO.builder()
                .id(course.getId())
                .name(course.getName())
                .preview(preview)
                .description(course.getDescription())
                .image(course.getImage())
                .likeCount(likeCount)
                .category1(course.getCategory1())
                .category2(course.getCategory2())
                .category3(course.getCategory3())
                .byService(course.getByService())
                .byResidents(course.getByResidents())
                .placeList(placeList)
                .build();
    }

}
