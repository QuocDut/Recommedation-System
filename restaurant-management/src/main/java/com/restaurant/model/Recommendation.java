package com.restaurant.model;

public class Recommendation {
    private int userId;
    private int restaurantId;
    private int rating;

    public Recommendation(int userId, int restaurantId, int rating) {
        this.userId = userId;
        this.restaurantId = restaurantId;
        this.rating = rating;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}