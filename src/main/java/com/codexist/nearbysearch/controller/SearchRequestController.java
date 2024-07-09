package com.codexist.nearbysearch.controller;

import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.services.abstracts.SearchRequestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/nearby-search")
@AllArgsConstructor
@CrossOrigin
public class SearchRequestController {

    private final SearchRequestService searchRequestService;

    @GetMapping()
    public ResponseEntity<PlaceResponseDto> searchRequest(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam int radius
    ) {
        return ResponseEntity.ok(this.searchRequestService.searchRequest(latitude, longitude, radius));
    }
}
