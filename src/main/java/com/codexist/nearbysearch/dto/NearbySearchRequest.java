package com.codexist.nearbysearch.dto;

public record NearbySearchRequest(
        double latitude,
        double longitude,
        int radius
        ) {
}
