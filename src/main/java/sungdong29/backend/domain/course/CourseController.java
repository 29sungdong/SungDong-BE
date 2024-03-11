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
import sungdong29.backend.domain.course.dto.response.CourseIdResponseDTO;
import sungdong29.backend.domain.course.service.CourseService;
import sungdong29.backend.global.config.user.UserDetails;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@Tag(name = "Course")
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "코스 생성")
    @PostMapping()
    public ResponseEntity<CourseIdResponseDTO> createCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestBody CourseCreateRequestDTO courseCreateRequestDTO) {
        log.info("코스 생성");
        CourseIdResponseDTO courseIdResponseDTO = courseService.createCourse(userDetails, courseCreateRequestDTO);
        return ResponseEntity.ok(courseIdResponseDTO);
    }

    @Operation(summary = "내 코스 수정")
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseIdResponseDTO> updateCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId,
            @RequestBody CourseCreateRequestDTO courseInfoRequestDTO
    ) {
        log.info("코스 수정");
        CourseIdResponseDTO courseIdResponseDTO = courseService.updateCourse(userDetails, courseId, courseInfoRequestDTO);
        return ResponseEntity.ok(courseIdResponseDTO);
    }

    @Operation(summary = "내 코스 삭제")
    @DeleteMapping("/{courseId}")
    public ResponseEntity<Void> deleteCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId
    ) {
        log.info("코스 삭제");
        courseService.deleteCourse(userDetails, courseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(summary = "코스 좋아요 상태 변경")
    @PostMapping("/{courseId}/like")
    public ResponseEntity<Void> likeCourse(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long courseId
    ) {
        log.info("코스 좋아요 상태 변성");
        courseService.changeCourseLike(userDetails, courseId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
