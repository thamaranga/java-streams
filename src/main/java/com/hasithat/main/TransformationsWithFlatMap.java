package com.hasithat.main;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransformationsWithFlatMap {

    public static void main(String[] args) {

        List<List<String>> arrayListOfNames = Arrays.asList(
                Arrays.asList("Mariam", "Alex", "Ismail"),
                Arrays.asList("John", "Alesha", "Andre"),
                Arrays.asList("Susy", "Ali")
        );

        List<String> listOfNames = arrayListOfNames.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        listOfNames.forEach(p -> System.out.println(p));

    }


}

