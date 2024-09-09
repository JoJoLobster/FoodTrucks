package com.ft.demo.service.vo;

import java.math.BigDecimal;
import java.util.List;

public class FoodTruck {
    private String applicant;
    private String type;
    private String address;
    private String locationDescription;
    private BigDecimal longitude;
    private BigDecimal latitude;
    private List<String> foodItems;

    public String getApplicant() {
        return applicant;
    }

    public void setApplicant(String applicant) {
        this.applicant = applicant;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocationDescription() {
        return locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public List<String> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<String> foodItems) {
        this.foodItems = foodItems;
    }

    

    @Override
    public String toString() {
        return "FoodTruck{" +
                "applicant='" + applicant + '\'' +
                ", type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", locationDescription='" + locationDescription + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
