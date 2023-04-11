package com.hasithat.main;


import com.hasithat.beans.Car;
import com.hasithat.mockdata.MockData;

import java.util.*;
import java.util.stream.Collectors;

public class StatisticsWithStreams {

    public static void main(String[] args) {
        try {
            count();
            System.out.println("******************************");
            min();
            System.out.println("******************************");
            max();
            System.out.println("******************************");
            average();
            System.out.println("******************************");
            sum();
            System.out.println("******************************");
            allStats();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void count() throws Exception {
        List<Car> cars = MockData.getCars();
        long count = cars.stream().count();
        System.out.println("Cars count " + count);
    }


    public static void min() throws Exception {
        List<Car> cars = MockData.getCars();
        Optional<Car> carWithMinPrice = cars.stream().min(Comparator.comparing(Car::getPrice));
        if (carWithMinPrice.isPresent()) {
            Car car = carWithMinPrice.get();
            System.out.println(car);
        }
    }


    public static void max() throws Exception {
        List<Car> cars = MockData.getCars();
        Optional<Car> carWithMaxPrice = cars.stream().max(Comparator.comparing(Car::getPrice));
        if (carWithMaxPrice.isPresent()) {
            Car car = carWithMaxPrice.get();
            System.out.println(car);
        }
    }


    public static void average() throws Exception {
        List<Car> cars = MockData.getCars();
        OptionalDouble average = cars.stream().mapToDouble(Car::getPrice).average();
        if (average.isPresent()) {
            double averagePrice = average.getAsDouble();
            System.out.println(averagePrice);
        }
    }


    public static void sum() throws Exception {
        List<Car> cars = MockData.getCars();
        double sum = cars.stream().mapToDouble(Car::getPrice).sum();
        System.out.println(sum);
    }

    public static void allStats() throws Exception {
        List<Car> cars = MockData.getCars();
        DoubleSummaryStatistics doubleSummaryStatistics=cars.stream().mapToDouble(a->a.getPrice()).summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }


}