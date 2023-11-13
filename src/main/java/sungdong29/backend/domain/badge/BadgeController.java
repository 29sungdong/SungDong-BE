package sungdong29.backend.domain.badge;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sungdong29.backend.domain.badge.dto.response.BadgesResponseDTO;
import sungdong29.backend.domain.badge.service.BadgeService;
import sungdong29.backend.global.config.LoginUser;

@RestController
@RequiredArgsConstructor
@RequestMapping()
@Tag(name = "Badge")
public class BadgeController {
    private final BadgeService badgeService;

    @GetMapping("/user/badges")
    public ResponseEntity<BadgesResponseDTO> findUserBadges(@LoginUser Long userId) {
        BadgesResponseDTO badgesResponseDTO = badgeService.findUserBadges(userId);
        return ResponseEntity.ok(badgesResponseDTO);
    }
}
