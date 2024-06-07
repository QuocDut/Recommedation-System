package com.restaurant.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.restaurant.model.Recommendation;
import com.restaurant.repository.RecommendationRepository;

import java.util.ArrayList;
import java.util.List;

public class RecommendationServiceTest {

    private RecommendationService recommendationService;
    private RecommendationRepository recommendationRepository;

    @BeforeEach
    public void setUp() {
        recommendationRepository = mock(RecommendationRepository.class);
        recommendationService = new RecommendationService(recommendationRepository);
    }

    @Test
    public void testGetRecommendationsByUserId() {
        // Mock the recommendation data
        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(new Recommendation(1, 1, 5));
        recommendations.add(new Recommendation(1, 2, 4));
        recommendations.add(new Recommendation(1, 3, 3));

        // Mock the repository method
        when(recommendationRepository.findByUserId(1)).thenReturn(recommendations);

        // Call the service method
        List<Recommendation> result = recommendationService.getRecommendationsByUserId(1);

        // Assert the result
        assertEquals(recommendations, result);
    }

    @Test
    public void testGetRecommendationsByRestaurantId() {
        // Mock the recommendation data
        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(new Recommendation(1, 1, 5));
        recommendations.add(new Recommendation(2, 1, 4));
        recommendations.add(new Recommendation(3, 1, 3));

        // Mock the repository method
        when(recommendationRepository.findByRestaurantId(1)).thenReturn(recommendations);

        // Call the service method
        List<Recommendation> result = recommendationService.getRecommendationsByRestaurantId(1);

        // Assert the result
        assertEquals(recommendations, result);
    }

    @Test
    public void testGetAverageRatingByRestaurantId() {
        // Mock the recommendation data
        List<Recommendation> recommendations = new ArrayList<>();
        recommendations.add(new Recommendation(1, 1, 5));
        recommendations.add(new Recommendation(2, 1, 4));
        recommendations.add(new Recommendation(3, 1, 3));

        // Mock the repository method
        when(recommendationRepository.findByRestaurantId(1)).thenReturn(recommendations);

        // Call the service method
        double result = recommendationService.getAverageRatingByRestaurantId(1);

        // Assert the result
        assertEquals(4.0, result);
    }
}