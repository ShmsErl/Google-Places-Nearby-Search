package com.codexist.nearbysearch.services.abstracts;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.models.SearchRequest;

public interface SearchRequestService {

    PlaceResponseDto searchRequest(double latitude, double longitude, int radius);

    SearchRequest getSearchRequest(double latitude, double longitude, int radius);
}
