package sungdong29.backend.domain.course.helper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CourseHelper {

    public String getCoursePreview(List<Place> placeList) {
        StringBuilder previewBuilder = new StringBuilder();
        for (Place place : placeList) {
            if (previewBuilder.length() > 0) {
                previewBuilder.append(" - ");
            }
            previewBuilder.append(place.getName());
        }
        return previewBuilder.toString();
    }
}
