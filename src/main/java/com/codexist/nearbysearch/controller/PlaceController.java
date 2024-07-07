package com.codexist.nearbysearch.controller;

import com.codexist.nearbysearch.services.abstracts.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/nearby-search")
@AllArgsConstructor
public class PlaceController {

    private final PlaceService placeService;



}
