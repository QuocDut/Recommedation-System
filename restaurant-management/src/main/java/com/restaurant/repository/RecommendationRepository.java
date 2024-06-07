package com.restaurant.repository;

import com.restaurant.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    // Add custom methods for recommendation retrieval based on user preferences
}