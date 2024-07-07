package com.codexist.nearbysearch.dto.responses;

public record NearbySearchResponse(
        String placeId,
        String name,
        String address,
        double latitude,
        double longitude) {
}