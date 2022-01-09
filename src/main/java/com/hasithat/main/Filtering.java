package com.hasithat.main;


import com.hasithat.beans.Car;
import com.hasithat.mockdata.MockData;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Filtering {

    public static void main(String[] args) {
        try {
            filter();
            System.out.println("******************************");
            findFirst();
            System.out.println("******************************");
            findAny();
            System.out.println("******************************");
            allMatch();
            System.out.println("******************************");
            anyMatch();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    public static void filter() throws Exception {
        List<Car> cars = MockData.getCars();
        List<Car> carsPriceLessThan2000 = cars.stream().filter(car -> car.getPrice() < 20000).filter(car -> car.getColor().equalsIgnoreCase("Red")).collect(Collectors.toList());
        carsPriceLessThan2000.forEach(car -> System.out.println(car));
    }


    public static void findFirst() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        OptionalInt first = Arrays.stream(numbers).findFirst();
        if (first.isPresent()) {
            int firstNumber = first.getAsInt();
            System.out.println(firstNumber);
        }
    }


    public static void findAny() throws Exception {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 10};
        OptionalInt any = Arrays.stream(numbers).findAny();
        if (any.isPresent()) {
            int anyNumber = any.getAsInt();
            System.out.println(anyNumber);
        }
    }


    public static void allMatch() throws Exception {
        int[] even = {2, 4, 6, 8, 10};
        boolean allMatch = Arrays.stream(even).allMatch(i -> i % 2 == 0);
        System.out.println(allMatch);
    }


    public static void anyMatch() throws Exception {
        int[] evenAndOneOdd = {2, 4, 6, 8, 10, 11};
        boolean anyMatch = Arrays.stream(evenAndOneOdd).anyMatch(i -> i > 0);
        System.out.println(anyMatch);
    }

}



