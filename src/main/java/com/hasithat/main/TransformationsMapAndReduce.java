package com.hasithat.main;


import com.hasithat.beans.Car;
import com.hasithat.beans.Person;
import com.hasithat.beans.PersonDTO;
import com.hasithat.mockdata.MockData;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    public static void main(String[] args) {
        try {
            yourFirstTransformationWithMap();
            System.out.println("******************************");
            mapToDoubleAndFindAverageCarPrice();
            System.out.println("******************************");
            reduce();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }


    static void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();
        List<PersonDTO> pearsonDTOList = people.stream().map(pearson -> PersonDTO.map(pearson)).collect(Collectors.toList());
        pearsonDTOList.forEach(System.out::println);
    }


    static void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        OptionalDouble average = cars.stream().mapToDouble(car -> car.getPrice()).average();
        if (average.isPresent()) {
            System.out.println(average.getAsDouble());
        }
    }


    public static void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        int reduce = Arrays.stream(integers).reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}

