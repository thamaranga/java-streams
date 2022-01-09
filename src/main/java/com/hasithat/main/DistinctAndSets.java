package com.hasithat.main;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DistinctAndSets {
    public static void main(String[] args) {
        try {
            distinct();
            System.out.println("******************************");
            distinctWithSet();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void distinct() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        List<Integer> distinctIntegerList = numbers.stream().distinct().collect(Collectors.toList());
        distinctIntegerList.forEach(number -> System.out.println(number));
    }


    public static void distinctWithSet() throws Exception {
        List<Integer> numbers = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9);
        Set<Integer> distinctIntegerSet = numbers.stream().collect(Collectors.toSet());
        distinctIntegerSet.forEach(number -> System.out.println(number));
    }
}
