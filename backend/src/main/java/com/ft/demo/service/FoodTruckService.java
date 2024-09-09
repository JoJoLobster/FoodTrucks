package com.ft.demo.service;

import com.ft.demo.service.vo.FoodTruck;

import java.util.List;

public interface FoodTruckService {
    /**
     * get all food trucks and return a list
     * @return
     */
    public List<FoodTruck> searchAll();

    /**
     * get by city and foodName
     * @param city
     * @return
     */
    public List<FoodTruck> searchByCityWithLike(String city, String foodName);

}
