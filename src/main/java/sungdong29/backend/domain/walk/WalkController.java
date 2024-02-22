package sungdong29.backend.domain.walk;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.walk.dto.response.WalkPathResponseDTO;
import sungdong29.backend.domain.walk.service.WalkService;
import sungdong29.backend.global.config.user.UserDetails;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/walk")
@Tag(name = "Walk")
public class WalkController {
    private final WalkService walkService;

    @Operation(summary = "산책로 경로 반환")
    @GetMapping("places/{placeId}")
    public WalkPathResponseDTO getWalkPath(
            @RequestParam String xCoordinate,
            @RequestParam String yCoordinate,
            @PathVariable Long placeId
            ) {
        return walkService.getWalkPath(xCoordinate, yCoordinate, placeId);
    }

    @Operation(summary = "산책 기록 저장")
    @PostMapping(value = "places/{placeId}")
    public ResponseEntity<Void> createWalkRecord(
            @AuthenticationPrincipal UserDetails userDetails,
            @PathVariable Long placeId) {
        walkService.createWalkRecord(userDetails, placeId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
