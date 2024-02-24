package sungdong29.backend.domain.event;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sungdong29.backend.domain.event.domain.Category;
import sungdong29.backend.domain.event.dto.response.CalenderResponseDTO;
import sungdong29.backend.domain.event.dto.response.EventListResponseDTO;
import sungdong29.backend.domain.event.service.EventService;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/events")
@Tag(name = "Event")
public class EventController {

    private final EventService eventService;

    @Operation(summary = "행사 리스트 조회")
    @GetMapping
    public EventListResponseDTO getEvents(
            @RequestParam(value = "category", required = false) List<Category> category,
            @RequestParam(value = "placeId", required = false) Long placeId) {
        log.info("행사 리스트 조회");
        return eventService.getEventList(category, placeId);
    }

    @Operation(summary = "행사 달력 조회")
    @GetMapping("calender")
    public CalenderResponseDTO getEventCalender(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate) {
        return eventService.getEventCalender(startDate, endDate);
    }
}
