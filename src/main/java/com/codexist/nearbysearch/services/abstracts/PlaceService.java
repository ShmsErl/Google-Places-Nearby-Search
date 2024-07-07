package com.codexist.nearbysearch.services.abstracts;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;


public interface PlaceService {

    PlaceResponseDto searchNearbyPlaces(double lat, double lng, int radius) ;

    PlaceResponseDto savePlacesFromApiToDatabase(double latitude, double longitude, int radius);
}
