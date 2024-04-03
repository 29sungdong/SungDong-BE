package sungdong29.backend.domain.course;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.course.dto.request.CourseCreateRequestDTO;
import sungdong29.backend.domain.course.dto.response.SimpleCourseResponseDTO;
import sungdong29.backend.domain.course.service.CourseService;
import sungdong29.backend.domain.course.domain.Category;
import sungdong29.backend.global.config.user.UserDetails;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@Tag(name = "Course")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "내 코스 조회")
    @GetMapping("/my")
    public ResponseEntity<List<SimpleCourseResponseDTO>> getMyCourse(
            @AuthenticationPrincipal UserDetails userDetails
    ) {
        log.info("내 코스 조회");
        List<SimpleCourseResponseDTO> simpleCourseResponseDTO = courseService.getMyCourse(userDetails);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    //카테고리 별 코스 조회
    @Operation(summary = "카테고리 별 코스 조회")
    @GetMapping("/category/{category}")
    public ResponseEntity<List<SimpleCourseResponseDTO>> getCourseByCategory(
            @RequestParam("category") Category category
    ) {
        log.info("카테고리 별 코스 조회");
        List<SimpleCourseResponseDTO> simpleCourseResponseDTO = courseService.getCourseByCategory(category);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    //코스 검색
    @Operation(summary = "코스 검색")
    @GetMapping("/search")
    public ResponseEntity<List<SimpleCourseResponseDTO>> searchCourse(
            @RequestParam("keyword") String keyword
    ) {
        log.info("코스 검색");
        List<SimpleCourseResponseDTO> simpleCourseResponseDTO = courseService.searchCourse(keyword);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    //장소로 코스 검색
    @Operation(summary = "장소로 코스 검색")
    @GetMapping("/place/{placeId}")
    public ResponseEntity<List<SimpleCourseResponseDTO>> searchCourseByPlace(
            @RequestParam("placeId") Long placeId
    ) {
        log.info("장소로 코스 검색");
        List<SimpleCourseResponseDTO> simpleCourseResponseDTO = courseService.searchCourseByPlace(placeId);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    @Operation(summary = "코스 생성")
    @PostMapping()
    public ResponseEntity<SimpleCourseResponseDTO> createCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CourseCreateRequestDTO courseCreateRequestDTO) {
        log.info("코스 생성");
        SimpleCourseResponseDTO simpleCourseResponseDTO = courseService.createCourse(userDetails, courseCreateRequestDTO);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    @Operation(summary = "내 코스 수정")
    @PatchMapping("/{courseId}")
    public ResponseEntity<SimpleCourseResponseDTO> updateCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId,
            @RequestBody CourseCreateRequestDTO courseInfoRequestDTO
    ) {
        log.info("내 코스 수정");
        SimpleCourseResponseDTO simpleCourseResponseDTO = courseService.updateCourse(userDetails, courseId, courseInfoRequestDTO);
        return ResponseEntity.ok(simpleCourseResponseDTO);
    }

    @Operation(summary = "내 코스 삭제")
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId
    ) {
        log.info("내 코스 삭제");
        courseService.deleteCourse(userDetails, courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "코스 좋아요 상태 변경")
    @PostMapping("/{courseId}/like")
    public ResponseEntity<Void> likeCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId
    ) {
        log.info("코스 좋아요 상태 변경");
        courseService.changeCourseLike(userDetails, courseId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
