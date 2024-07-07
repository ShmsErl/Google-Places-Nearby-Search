package com.codexist.nearbysearch.services.concretes;

import com.codexist.nearbysearch.dto.responses.NearbySearchResponse;
import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.repositories.PlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PlaceManager {


    private final RestTemplate restTemplate;
    private final PlaceRepository placeRepository;

    @Autowired
    public PlaceManager(RestTemplate restTemplate, PlaceRepository placeRepository) {
        this.restTemplate = restTemplate;
        this.placeRepository = placeRepository;
    }

    public NearbySearchResponse searchNearbyPlaces(double lat, double lng, int radius) {
        String apiKey = "YOUR_API_KEY";
        String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%f,%f&radius=%d&key=%s",
                lat, lng, radius, apiKey);

        NearbySearchResponse response = restTemplate.getForObject(url, NearbySearchResponse.class);

        // Save the response to the database or handle caching
        if (response != null) {
            response.streforEach(placeDto -> {
                Place place = new Place();
                place.setName(placeDto.getName());
                place.setLat(placeDto.getLat());
                place.setLng(placeDto.getLng());
                placeRepository.save(place);
            });
        }

        return response;
    }



}
