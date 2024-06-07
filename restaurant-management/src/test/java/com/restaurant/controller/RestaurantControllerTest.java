package com.restaurant.controller;

import com.restaurant.model.Restaurant;
import com.restaurant.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RestaurantControllerTest {

    @Mock
    private RestaurantService restaurantService;

    @InjectMocks
    private RestaurantController restaurantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllRestaurants_ReturnsListOfRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1L, "Restaurant 1", "Address 1", "Cuisine 1"));
        restaurants.add(new Restaurant(2L, "Restaurant 2", "Address 2", "Cuisine 2"));

        when(restaurantService.getAllRestaurants()).thenReturn(restaurants);

        ResponseEntity<List<Restaurant>> response = restaurantController.getAllRestaurants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurants, response.getBody());
        verify(restaurantService, times(1)).getAllRestaurants();
    }

    @Test
    void createRestaurant_ReturnsCreatedRestaurant() {
        Restaurant restaurant = new Restaurant(1L, "Restaurant 1", "Address 1", "Cuisine 1");

        when(restaurantService.createRestaurant(restaurant)).thenReturn(restaurant);

        ResponseEntity<Restaurant> response = restaurantController.createRestaurant(restaurant);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(restaurant, response.getBody());
        verify(restaurantService, times(1)).createRestaurant(restaurant);
    }

    // Add more test cases for other methods in the RestaurantController class

}