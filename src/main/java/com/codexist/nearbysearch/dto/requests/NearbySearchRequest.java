package com.codexist.nearbysearch.dto.requests;

public record NearbySearchRequest(
        double latitude,
        double longitude,
        int radius
        ) {
}
