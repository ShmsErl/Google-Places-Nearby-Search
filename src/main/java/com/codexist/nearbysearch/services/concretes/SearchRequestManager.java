package com.codexist.nearbysearch.services.concretes;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.exception.NotFoundException;
import com.codexist.nearbysearch.models.SearchRequest;
import com.codexist.nearbysearch.repositories.SearchRequestRepository;
import com.codexist.nearbysearch.services.abstracts.GooglePlaceService;
import com.codexist.nearbysearch.services.abstracts.SearchRequestService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SearchRequestManager implements SearchRequestService {


    private final SearchRequestRepository searchRequestRepository;

    private final GooglePlaceService placeService;


    @Override
    public PlaceResponseDto searchRequest(double latitude, double longitude, int radius) {
        boolean result = this.searchRequestRepository.existsByLatitudeAndLongitudeAndRadius(latitude, longitude, radius);

        if (result) {
            return this.placeService.getAllPlacesAccordingToSearchRequest(this.getSearchRequest(latitude, longitude, radius));


        } else {

           SearchRequest request =  this.searchRequestRepository.save(
                    SearchRequest.builder()
                            .latitude(latitude)
                            .longitude(longitude)
                            .radius(radius)
                            .build()
            );


            return this.placeService.savePlacesFromApiToDatabase(latitude, longitude, radius,request);

        }


    }

    @Override
    public SearchRequest getSearchRequest(double latitude, double longitude, int radius) {
        return this.searchRequestRepository.findByLatitudeAndLongitudeAndRadius(latitude, longitude, radius)
                .orElseThrow(() -> new NotFoundException("Could not find"));
    }
}
