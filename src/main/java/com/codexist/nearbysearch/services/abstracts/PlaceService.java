package com.codexist.nearbysearch.services.abstracts;

import com.codexist.nearbysearch.dto.responses.NearbySearchResponse;

import java.util.List;

public interface PlaceService {

    List<NearbySearchResponse> getLocations();
}
