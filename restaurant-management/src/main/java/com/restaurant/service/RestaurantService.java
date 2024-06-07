package com.restaurant.service;

import com.restaurant.model.Restaurant;
import com.restaurant.repository.RestaurantRepository;

import java.util.List;

public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.getAllRestaurants();
    }

    public Restaurant getRestaurantById(int id) {
        return restaurantRepository.getRestaurantById(id);
    }

    public void createRestaurant(Restaurant restaurant) {
        restaurantRepository.createRestaurant(restaurant);
    }

    public void updateRestaurant(int id, Restaurant restaurant) {
        restaurantRepository.updateRestaurant(id, restaurant);
    }

    public void deleteRestaurant(int id) {
        restaurantRepository.deleteRestaurant(id);
    }
}