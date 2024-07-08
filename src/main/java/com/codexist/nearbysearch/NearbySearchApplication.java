package com.codexist.nearbysearch;

import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.repositories.GooglePlaceRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@AllArgsConstructor
public class NearbySearchApplication implements CommandLineRunner {

    private final GooglePlaceRepository placeRepository;

    public static void main(String[] args) {
        SpringApplication.run(NearbySearchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       Place test =  Place.builder()
                .placeId("ChIJAUn6iyYSKxURNGAXrEYxMBo")
                .vicinity("Gümüşsuyu, Sıraselviler Caddesi No:5")
                .name("Taxim Hill Hotel")
                .geometry(Place.Geometry.builder()
                        .location(Place.Geometry.Location.builder()
                                .lat(41.0364943)
                                .lng(28.9854955)
                                .build())
                        .build())
               .build();

       this.placeRepository.save(test);



    }
}
