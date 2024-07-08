package com.codexist.nearbysearch.dto.requests;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class NearbySearchRequest {

        @NotNull(message = "Latitude cannot be null")
        @DecimalMin(value = "-90.0", message = "Latitude must be at least -90.0")
        @DecimalMax(value = "90.0", message = "Latitude must be at most 90.0")
        private Double latitude;

        @NotNull(message = "Longitude cannot be null")
        @DecimalMin(value = "-180.0", message = "Longitude must be at least -180.0")
        @DecimalMax(value = "180.0", message = "Longitude must be at most 180.0")
        private Double longitude;

        @PositiveOrZero(message = "Radius must be a positive number or zero")
        private Integer radius;

        public NearbySearchRequest() {
        }

        // Parameterized constructor
        public NearbySearchRequest(Double latitude, Double longitude, Integer radius) {
                this.latitude = latitude;
                this.longitude = longitude;
                this.radius = radius;
        }

        // Getters and setters
        public Double getLatitude() {
                return latitude;
        }

        public void setLatitude(Double latitude) {
                this.latitude = latitude;
        }

        public Double getLongitude() {
                return longitude;
        }

        public void setLongitude(Double longitude) {
                this.longitude = longitude;
        }

        public Integer getRadius() {
                return radius;
        }

        public void setRadius(Integer radius) {
                this.radius = radius;
        }
}
