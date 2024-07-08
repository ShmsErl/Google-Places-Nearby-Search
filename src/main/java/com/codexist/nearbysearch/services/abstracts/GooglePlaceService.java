package com.codexist.nearbysearch.services.abstracts;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.models.SearchRequest;

import java.util.List;


public interface GooglePlaceService {

    PlaceResponseDto searchNearbyPlaces(double lat, double lng, int radius) ;

    PlaceResponseDto savePlacesFromApiToDatabase(double latitude, double longitude, int radius, SearchRequest searchRequest);

    PlaceResponseDto getAllPlacesAccordingToSearchRequest(SearchRequest searchRequest);
}
