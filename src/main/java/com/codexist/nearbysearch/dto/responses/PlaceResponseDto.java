package com.codexist.nearbysearch.dto.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;
@Builder
public class PlaceResponseDto {

    @JsonProperty("html_attributions")
    private List<Object> htmlAttributions;

    @JsonProperty("results")
    private List<PlaceDto> results;

    @JsonProperty("status")
    private String status;


    public List<Object> getHtmlAttributions() {
        return htmlAttributions;
    }

    public void setHtmlAttributions(List<Object> htmlAttributions) {
        this.htmlAttributions = htmlAttributions;
    }

    public List<PlaceDto> getResults() {
        return results;
    }

    public void setResults(List<PlaceDto> results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
