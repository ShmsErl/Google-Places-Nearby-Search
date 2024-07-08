package com.codexist.nearbysearch.models;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "search_requests")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class SearchRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;
    private double longitude;
    private int radius;

    @OneToMany(mappedBy = "searchRequestId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Place> places;

    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
