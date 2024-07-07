package com.codexist.nearbysearch.services.concretes;

import com.codexist.nearbysearch.dto.responses.PlaceDto;
import com.codexist.nearbysearch.dto.responses.PlaceResponseDto;
import com.codexist.nearbysearch.mappers.PlaceConverter;
import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.repositories.PlaceRepository;
import com.codexist.nearbysearch.services.abstracts.PlaceService;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;


import java.util.Locale;

@Service
public class PlaceManager implements PlaceService {


    private final RestTemplate restTemplate;
    private final PlaceRepository placeRepository;





    @Autowired
    public PlaceManager(RestTemplate restTemplate, PlaceRepository placeRepository) {
        this.restTemplate = restTemplate;
        this.placeRepository = placeRepository;

    }









}
