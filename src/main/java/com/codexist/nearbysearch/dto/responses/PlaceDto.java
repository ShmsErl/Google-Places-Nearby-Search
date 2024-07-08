package com.codexist.nearbysearch.dto.responses;

import com.codexist.nearbysearch.models.Place;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public class PlaceDto {

    @JsonProperty("place_id")
    private String placeId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("vicinity")
    private String vicinity;

    @JsonProperty("geometry")
    private Place.Geometry geometry;

    public long getSearchRequestId() {
        return searchRequestId;
    }

    public void setSearchRequestId(long searchRequestId) {
        this.searchRequestId = searchRequestId;
    }

    private long searchRequestId;



    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVicinity() {
        return vicinity;
    }

    public void setVicinity(String vicinity) {
        this.vicinity = vicinity;
    }

    public Place.Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Place.Geometry geometry) {
        this.geometry = geometry;
    }
}
