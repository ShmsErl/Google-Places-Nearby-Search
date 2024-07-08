package com.codexist.nearbysearch.services.concretes;

import com.codexist.nearbysearch.dto.responses.PlaceDto;
import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.mappers.PlaceConverter;
import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.models.SearchRequest;
import com.codexist.nearbysearch.repositories.GooglePlaceRepository;
import com.codexist.nearbysearch.services.abstracts.GooglePlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Locale;

@Service
public class GooglePlaceManager implements GooglePlaceService {


    private final RestTemplate restTemplate;
    private final GooglePlaceRepository placeRepository;
    private final PlaceConverter placeConverter;


    @Value("${google.places.api.key}")
    private String API_KEY;


    @Autowired
    public GooglePlaceManager(RestTemplate restTemplate, GooglePlaceRepository placeRepository, PlaceConverter placeConverter) {
        this.restTemplate = restTemplate;
        this.placeRepository = placeRepository;
        this.placeConverter = placeConverter;
    }


    @Transactional
    public PlaceResponseDto savePlacesFromApiToDatabase(double latitude, double longitude, int radius, SearchRequest searchRequest) {
        PlaceResponseDto placeResponseDto = searchNearbyPlaces(latitude, longitude, radius);

        if (placeResponseDto != null && !placeResponseDto.getResults().isEmpty()) {


            for (PlaceDto placeDto : placeResponseDto.getResults()) {
                Place place = placeConverter.convertToPlace(placeDto);
                place.setSearchRequestId(searchRequest);
                placeRepository.save(place);
            }
        }

        return placeResponseDto;
    }


    public PlaceResponseDto searchNearbyPlaces(double latitude, double longitude, int radius) {

        String locationParam = String.format(Locale.US, "%f,%f", latitude, longitude);
        String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s&radius=%d&key=%s",
                locationParam, radius, API_KEY);


        return restTemplate.getForObject(url, PlaceResponseDto.class);
    }

    @Override
    public PlaceResponseDto getAllPlacesAccordingToSearchRequest(SearchRequest searchRequest) {

        List<PlaceDto> places = this.placeRepository.findBySearchRequest(searchRequest)
                .stream().map(this.placeConverter::convertToPlaceDto
                ).toList();

        return PlaceResponseDto.builder().htmlAttributions(List.of("Connected to Database")).results(places).status("Ok").build();
    }
}
