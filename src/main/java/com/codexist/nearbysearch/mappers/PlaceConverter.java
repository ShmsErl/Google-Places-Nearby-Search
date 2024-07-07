package com.codexist.nearbysearch.mappers;

import com.codexist.nearbysearch.dto.responses.PlaceDto;
import com.codexist.nearbysearch.models.Place;
import org.springframework.stereotype.Component;


@Component
public class PlaceConverter {


    public Place convertToPlace(PlaceDto placeDto) {
        return Place.builder()
                .placeId(placeDto.getPlaceId())
                .name(placeDto.getName())
                .vicinity(placeDto.getVicinity())
                .geometry(placeDto.getGeometry())
                .build();
    }


    public PlaceDto convertToPlaceDto(Place place) {

        return PlaceDto.builder()
                .placeId(place.getPlaceId())
                .name(place.getName())
                .vicinity(place.getVicinity())
                .geometry(place.getGeometry())
                .build();
    }

}
