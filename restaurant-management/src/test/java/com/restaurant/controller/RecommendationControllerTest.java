package com.restaurant.controller;

import com.restaurant.model.Recommendation;
import com.restaurant.service.RecommendationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecommendationControllerTest {

    private MockMvc mockMvc;

    @Mock
    private RecommendationService recommendationService;

    @InjectMocks
    private RecommendationController recommendationController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(recommendationController).build();
    }

    @Test
    public void testGetRecommendations() throws Exception {
        Recommendation recommendation1 = new Recommendation(1, 1, 4.5);
        Recommendation recommendation2 = new Recommendation(2, 2, 3.8);
        List<Recommendation> recommendations = Arrays.asList(recommendation1, recommendation2);

        when(recommendationService.getRecommendations()).thenReturn(recommendations);

        mockMvc.perform(get("/recommendations")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].userId").value(1))
                .andExpect(jsonPath("$[0].rating").value(4.5))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].userId").value(2))
                .andExpect(jsonPath("$[1].rating").value(3.8));

        verify(recommendationService, times(1)).getRecommendations();
        verifyNoMoreInteractions(recommendationService);
    }

    @Test
    public void testGetRecommendationById() throws Exception {
        Recommendation recommendation = new Recommendation(1, 1, 4.5);

        when(recommendationService.getRecommendationById(1)).thenReturn(recommendation);

        mockMvc.perform(get("/recommendations/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.rating").value(4.5));

        verify(recommendationService, times(1)).getRecommendationById(1);
        verifyNoMoreInteractions(recommendationService);
    }

    @Test
    public void testCreateRecommendation() throws Exception {
        Recommendation recommendation = new Recommendation(1, 1, 4.5);

        mockMvc.perform(post("/recommendations")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1, \"rating\": 4.5}"))
                .andExpect(status().isCreated());

        verify(recommendationService, times(1)).createRecommendation(recommendation);
        verifyNoMoreInteractions(recommendationService);
    }

    @Test
    public void testUpdateRecommendation() throws Exception {
        Recommendation recommendation = new Recommendation(1, 1, 4.5);

        mockMvc.perform(put("/recommendations/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"userId\": 1, \"rating\": 4.5}"))
                .andExpect(status().isOk());

        verify(recommendationService, times(1)).updateRecommendation(1, recommendation);
        verifyNoMoreInteractions(recommendationService);
    }

    @Test
    public void testDeleteRecommendation() throws Exception {
        mockMvc.perform(delete("/recommendations/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(recommendationService, times(1)).deleteRecommendation(1);
        verifyNoMoreInteractions(recommendationService);
    }
}