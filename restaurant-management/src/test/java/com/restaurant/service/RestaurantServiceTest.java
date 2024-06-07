package com.restaurant.service;

import com.restaurant.model.Restaurant;
import com.restaurant.repository.RestaurantRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        restaurants.add(new Restaurant(1, "Restaurant 1", "Address 1", "Cuisine 1"));
        restaurants.add(new Restaurant(2, "Restaurant 2", "Address 2", "Cuisine 2"));

        when(restaurantRepository.getAllRestaurants()).thenReturn(restaurants);

        List<Restaurant> result = restaurantService.getAllRestaurants();

        assertEquals(restaurants.size(), result.size());
        assertEquals(restaurants.get(0).getName(), result.get(0).getName());
        assertEquals(restaurants.get(1).getName(), result.get(1).getName());

        verify(restaurantRepository, times(1)).getAllRestaurants();
    }

    // Add more test cases for other methods in RestaurantService class

}