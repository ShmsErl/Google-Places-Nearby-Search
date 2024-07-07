package com.codexist.nearbysearch.services.concretes;

import com.codexist.nearbysearch.dto.responses.PlaceDto;
import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.mappers.PlaceConverter;
import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.repositories.PlaceRepository;
import com.codexist.nearbysearch.services.abstracts.PlaceService;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.Locale;

@Service
public class PlaceManager implements PlaceService {


    private final RestTemplate restTemplate;
    private final PlaceRepository placeRepository;
    private final PlaceConverter placeConverter;


    @Value("${google.places.api.key}")
    private String API_KEY;



    @Autowired
    public PlaceManager(RestTemplate restTemplate, PlaceRepository placeRepository, PlaceConverter placeConverter) {
        this.restTemplate = restTemplate;
        this.placeRepository = placeRepository;
        this.placeConverter = placeConverter;
    }


    @Transactional
    public PlaceResponseDto savePlacesFromApiToDatabase(double latitude, double longitude, int radius)  {
        PlaceResponseDto placeResponseDto = searchNearbyPlaces(latitude, longitude, radius);

        if (placeResponseDto != null && !placeResponseDto.getResults().isEmpty()) {


            for (PlaceDto placeDto : placeResponseDto.getResults()) {
                Place place = placeConverter.convertToPlace(placeDto);
                placeRepository.save(place);
            }
        }

        return placeResponseDto;
    }



    public PlaceResponseDto searchNearbyPlaces(double latitude, double longitude, int radius)  {

        String locationParam = String.format(Locale.US, "%f,%f", latitude, longitude);
        String url = String.format("https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=%s&radius=%d&key=%s",
                locationParam, radius, API_KEY);


        return restTemplate.getForObject(url, PlaceResponseDto.class);
    }









}
