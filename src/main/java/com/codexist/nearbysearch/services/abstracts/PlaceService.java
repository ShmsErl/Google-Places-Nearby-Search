package com.codexist.nearbysearch.services.abstracts;

import com.codexist.nearbysearch.dto.responses.NearbySearchResponse;
import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;

import java.util.List;

public interface PlaceService {

    PlaceResponseDto searchNearbyPlaces(double lat, double lng, int radius) ;
}
