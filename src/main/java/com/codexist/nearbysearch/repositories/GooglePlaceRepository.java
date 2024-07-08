package com.codexist.nearbysearch.repositories;

import com.codexist.nearbysearch.models.Place;
import com.codexist.nearbysearch.models.SearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GooglePlaceRepository extends JpaRepository<Place, String> {

    @Query("SELECT p FROM Place p WHERE p.searchRequestId = :searchRequest")
    List<Place> findBySearchRequest(@Param("searchRequest") SearchRequest searchRequest);
}
