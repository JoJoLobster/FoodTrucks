package com.ft.demo.rest;

import com.ft.demo.dto.RestResp;
import com.ft.demo.dto.TrucksSearchParam;
import com.ft.demo.service.FoodTruckService;
import com.ft.demo.service.vo.FoodTruck;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("food trunk api")
@RequestMapping("/api/trucks")
public class FoodTruckRest {

    private FoodTruckService foodTruckService;

    @Autowired
    public void FoodTruckRest(FoodTruckService foodTruckService) {
        this.foodTruckService = foodTruckService;
    }

    /**
     * Search trucks by city name and food name
     * @param param search param obj
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST)
    public RestResp<List<FoodTruck>> searchByParams(@RequestBody TrucksSearchParam param) {
        String city = param.getCity();
        String foodName = param.getFoodName();

        return RestResp.ok(foodTruckService.searchByCityWithLike(city, foodName));
    }

    /**
     * Search all trucks
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public RestResp<List<FoodTruck>> search() {
        return RestResp.ok(foodTruckService.searchAll());
    }


    /**
     * Search trucks by city
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/city/{city}")
    public RestResp<List<FoodTruck>> searchByCity(
            @PathVariable(value="city") String city) {
        return RestResp.ok(foodTruckService.searchByCityWithLike(city, null));
    }

    /**
     * Search trucks by food name
     * @param foodName
     * @return
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="/food/{foodName}")
    public RestResp<List<FoodTruck>> searchByFoodName(
            @PathVariable(value="foodName") String foodName) {
        return RestResp.ok(
                foodTruckService.searchByCityWithLike(null, foodName)
        );
    }
}
