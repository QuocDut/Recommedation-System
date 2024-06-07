package com.restaurant.controller;

import com.restaurant.model.Recommendation;
import com.restaurant.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recommendations")
public class RecommendationController {

    private final RecommendationService recommendationService;

    @Autowired
    public RecommendationController(RecommendationService recommendationService) {
        this.recommendationService = recommendationService;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Recommendation>> getRecommendationsByUserId(@PathVariable("userId") String userId) {
        List<Recommendation> recommendations = recommendationService.getRecommendationsByUserId(userId);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}