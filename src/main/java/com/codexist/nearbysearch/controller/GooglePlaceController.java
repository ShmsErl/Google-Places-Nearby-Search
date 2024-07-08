package com.codexist.nearbysearch.controller;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.services.abstracts.GooglePlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nearby")
@AllArgsConstructor
public class GooglePlaceController {

    private final GooglePlaceService placeService;

    @GetMapping
    public ResponseEntity<PlaceResponseDto> getNearbyPlaces(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int radius) {
        PlaceResponseDto response = placeService.searchNearbyPlaces(latitude, longitude, radius);
        return ResponseEntity.ok(response);
    }



}
