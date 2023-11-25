package sungdong29.backend.domain.walk;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sungdong29.backend.domain.walk.dto.request.WalkRecordRequestDTO;
import sungdong29.backend.domain.walk.service.WalkService;
import sungdong29.backend.global.config.LoginUser;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping
@Tag(name = "Walk")
public class WalkController {
    private final WalkService walkService;

    @Operation(summary = "산책 기록 저장")
    @PostMapping(value = "places/{placeId}/walk")
    public ResponseEntity<Void> createWalkRecord(
            @LoginUser Long userId,
            @PathVariable Long placeId,
            @RequestBody WalkRecordRequestDTO walkRecordRequestDTO) {
        walkService.createWalkRecord(userId, placeId, walkRecordRequestDTO);
        return ResponseEntity.ok().build();
    }
}
