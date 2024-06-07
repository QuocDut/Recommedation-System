package com.restaurant.model;

public class Restaurant {
    private String name;
    private String address;
    private String cuisineType;

    public Restaurant(String name, String address, String cuisineType) {
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }
}