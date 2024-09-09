package com.ft.demo.util;

import com.ft.demo.vo.FoodTruck;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CsvUtilTest {

    @Test
    void parseFoodTruckCsv() {
        List<FoodTruck> res = CsvUtil.parseFoodTruckCsv("Mobile_Food_Facility_Permit_One.csv");
        assertTrue(res.size() == 1);
        System.out.println(res);
    }
}