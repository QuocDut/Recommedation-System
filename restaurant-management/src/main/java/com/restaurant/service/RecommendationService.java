package com.restaurant.service;

import com.restaurant.model.Recommendation;
import com.restaurant.repository.RecommendationRepository;

import java.util.List;

public class RecommendationService {
    private RecommendationRepository recommendationRepository;

    public RecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    public List<Recommendation> getRecommendationsByUser(String userId) {
        return recommendationRepository.findByUserId(userId);
    }

    public List<Recommendation> getRecommendationsByRestaurant(String restaurantId) {
        return recommendationRepository.findByRestaurantId(restaurantId);
    }

    public void addRecommendation(Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }

    public void updateRecommendation(Recommendation recommendation) {
        recommendationRepository.save(recommendation);
    }

    public void deleteRecommendation(String recommendationId) {
        recommendationRepository.deleteById(recommendationId);
    }
}