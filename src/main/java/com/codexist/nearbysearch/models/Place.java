package com.codexist.nearbysearch.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "places")
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Place {
    @Id
    private String placeId;
    @Column(name = "name")
    private String name;
    @Column(name = "vicinity")
    private String vicinity;

    @Embedded
    private Geometry geometry;


    public Place(String placeId, String name, String address, Geometry geometry) {
        this.placeId = placeId;
        this.name = name;
        this.vicinity = address;
        this.geometry = geometry;
    }


    @Embeddable
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    public static class Geometry {
        @Embedded
        private Location location;


        @Embeddable
        @NoArgsConstructor
        @AllArgsConstructor
        @Builder
        @Getter
        @Setter
        public static class Location {
            private double lat;
            private double lng;

        }
    }


}
