 package com.ft.demo.service.impl;

import com.ft.demo.service.FoodTruckService;
import com.ft.demo.util.CsvUtil;
import com.ft.demo.service.vo.FoodTruck;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {
    private SoftReference<List<FoodTruck>> allCache;

    private Lock cacheUpdLock = new ReentrantLock();

    @Override
    public List<FoodTruck> searchAll() {
        cacheUpdLock.tryLock();
        if(allCache == null || allCache.get() == null) {
            allCache = new SoftReference<>(CsvUtil.parseFoodTruckCsv("Mobile_Food_Facility_Permit.csv"));

        }
        cacheUpdLock.unlock();
        return allCache.get();
    }

    @Override
    public List<FoodTruck> searchByCityWithLike(String city, String foodName) {
        String upperFoodName = foodName==null?"":foodName.toUpperCase();

        List<FoodTruck> all = Optional.of(searchAll()).
        orElseGet(()->new ArrayList<>());
        
        return all.stream()
                .filter(ft->{
                    if(StringUtils.hasText(city)) {
                        return ft.getAddress().contains(city) || ft.getLocationDescription().contains(city);
                    }
                    return true;
                })
                .filter(ft->{
                    if(StringUtils.hasText(foodName)) {
                        return ft.getFoodItems().stream().anyMatch(fi->upperFoodName.equals(foodName));
                    }
                    return true;
                })
                .collect(Collectors.toList());
    }

}
