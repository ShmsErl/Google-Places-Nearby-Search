package com.codexist.nearbysearch.controller;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.services.abstracts.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nearby-search")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @GetMapping
    public ResponseEntity<PlaceResponseDto> getNearbyPlaces(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int radius) {
        PlaceResponseDto response = placeService.searchNearbyPlaces(latitude, longitude, radius);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/save")
    public ResponseEntity<PlaceResponseDto> savePlaces(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int radius)  {

        return ResponseEntity.ok(placeService.savePlacesFromApiToDatabase(latitude, longitude, radius));
    }

}
