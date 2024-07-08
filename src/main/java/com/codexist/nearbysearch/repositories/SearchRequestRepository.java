package com.codexist.nearbysearch.repositories;

import com.codexist.nearbysearch.models.SearchRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SearchRequestRepository extends JpaRepository<SearchRequest, Long> {
    Optional<SearchRequest> findByLatitudeAndLongitudeAndRadius(double latitude, double longitude, int radius);

    boolean existsByLatitudeAndLongitudeAndRadius(double latitude, double longitude, int radius);
}
