package com.ft.demo.util;

import com.ft.demo.service.vo.FoodTruck;
import org.apache.commons.csv.CSVFormat;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class CsvUtil {

    // public static <T> List<T> parseFile(Class<T> t, String filePath, Map<String,
    // String> headerMap) throws IOException {
    // Reader in = new FileReader(CsvUtil.class.getResource("/" +
    // filePath).getPath());
    // List<T> resList = new ArrayList<>();
    //
    // final CSVParser parser = CSVFormat.EXCEL.builder()
    // .setHeader()
    // .build()
    // .parse(in);
    // for (CSVRecord record : parser) {
    // T instance = null;
    // try {
    // instance = (T) t.getDeclaredConstructors()[0].newInstance();
    //
    // } catch (InvocationTargetException | InstantiationException |
    // IllegalAccessException e) {
    // throw new RuntimeException("failed parse record:" + record);
    // }
    // if (instance != null) {
    // ReflectivePropertyAccessor a = new ReflectivePropertyAccessor();
    // for (Map.Entry<String, String> entry : headerMap.entrySet()) {
    // try {
    // Field field = instance.getClass().getField(entry.getKey());
    // field.setAccessible(true);
    // field.set(instance, entry.getValue());
    // } catch (IllegalAccessException | NoSuchFieldException e) {
    // e.printStackTrace();
    // throw new RuntimeException("failed convert cvs records to type:" + t + ",
    // err:" + e.getMessage());
    // }
    // }
    // resList.add(instance);
    // }
    // }
    // return resList;
    // }

    public static List<FoodTruck> parseFoodTruckCsv(String fileName) {
        String csvFilePath = CsvUtil.class.getClassLoader().getResource(fileName).getPath();
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("applicant", "Applicant");
        headerMap.put("type", "FacilityType");
        headerMap.put("address", "Address");
        headerMap.put("locationDescription", "LocationDescription");
        headerMap.put("longitude", "Longitude");
        headerMap.put("latitude", "Latitude");

        List<FoodTruck> resList = new ArrayList<>();
        try {
            System.out.println(csvFilePath);
            Reader in = new InputStreamReader(CsvUtil.class.getClassLoader().getResourceAsStream(fileName));

            resList = CSVFormat.EXCEL.builder()
                    .setHeader()
                    .build()
                    .parse(in).stream().map(record -> {
                        FoodTruck ft = new FoodTruck();
                        ft.setAddress(record.get("Address"));
                        ft.setApplicant(record.get("Applicant"));
                        ft.setType(record.get("FacilityType"));
                        ft.setLocationDescription(record.get("LocationDescription"));
                        ft.setLongitude(new BigDecimal(record.get("Longitude")));
                        ft.setLatitude(new BigDecimal(record.get("Latitude")));
                        if(record.get("FoodItems")!=null){
                            ft.setFoodItems(Arrays.asList(record.get("FoodItems").toUpperCase().split(":")));
                        } else {
                            ft.setFoodItems(new ArrayList<>());
                        }
                        return ft;
                    }).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("parse failed:" + e.getMessage());
        }
        return resList;
    }
}
