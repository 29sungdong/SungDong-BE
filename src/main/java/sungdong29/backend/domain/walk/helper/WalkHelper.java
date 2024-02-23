package sungdong29.backend.domain.walk.helper;

import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import okhttp3.*;

import org.springframework.stereotype.Component;
import sungdong29.backend.domain.place.domain.Place;
import sungdong29.backend.domain.walk.domain.Walk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class WalkHelper {

    @Value("${openapi.tmap.key}")
    private String TMAP_APP_KEY;

    public List<List<Double>> getLineString(String xCoordinate, String yCoordinate, Place place, Walk walk) {
        OkHttpClient client = new OkHttpClient();
        MediaType mediaType = MediaType.parse("application/json");
        String jsonString = "{\"startX\":" + xCoordinate + ",\"startY\":" + yCoordinate + ",\"endX\":" + place.getXCoordinate() + ",\"endY\":" + place.getYCoordinate() + ",\"passList\":\"" + walk.getXCoordinate() + ", " + walk.getYCoordinate() + "\",\"startName\":\"내 위치\",\"endName\":\"" + place.getName() + "\"}";
        RequestBody body = RequestBody.create(jsonString, mediaType);
        Request request = new Request.Builder()
                .url("https://apis.openapi.sk.com/tmap/routes/pedestrian?version=1&callback=function")
                .post(body)
                .addHeader("accept", "application/json")
                .addHeader("content-type", "application/json")
                .addHeader("appKey", TMAP_APP_KEY)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String stringResponse = response.body().string();
            return extractLineStringCoordinates(stringResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<List<Double>> extractLineStringCoordinates(String stringResponse) {
        List<List<Double>> lineStringCoordinates = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(stringResponse);
        JSONArray features = jsonObject.getJSONArray("features");

        for (int i = 0; i < features.length(); i++) {
            JSONObject feature = features.getJSONObject(i);
            JSONObject geometry = feature.getJSONObject("geometry");

            if ("LineString".equals(geometry.getString("type"))) {
                JSONArray coordinatesArray = geometry.getJSONArray("coordinates");

                if (i == 0) {
                    for (int j = 0; j < coordinatesArray.length(); j++) {
                        JSONArray coordinate = coordinatesArray.getJSONArray(j);
                        lineStringCoordinates.add(List.of(coordinate.getDouble(0), coordinate.getDouble(1)));
                    }
                }
                else {
                    for (int j = 1; j < coordinatesArray.length(); j++) {
                        JSONArray coordinate = coordinatesArray.getJSONArray(j);
                        lineStringCoordinates.add(List.of(coordinate.getDouble(0), coordinate.getDouble(1)));
                    }
                }
            }
        }
        return lineStringCoordinates;
    }

}
