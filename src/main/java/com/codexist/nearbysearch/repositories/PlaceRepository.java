package com.codexist.nearbysearch.repositories;

import com.codexist.nearbysearch.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository<Place, String> {

}
