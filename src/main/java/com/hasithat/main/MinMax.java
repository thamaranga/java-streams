package com.hasithat.main;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;

public class MinMax {
    public static void main(String[] args) {
        min();
        System.out.println("******************************");
        max();
        System.out.println("******************************");
        summaryStatics();
    }


    public static void min() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 100, 23, -7, 93, 99);
       /* Optional<Integer> min = numbers.stream().min((a, b) -> {
            if (a > b) return 1;
            else if (a < b) return -1;
            else return 0;
        });
        if (min.isPresent()) {
            int minValue = min.get();
            System.out.println(minValue);
        }*/
        //Integer minValue = numbers.stream().min(Integer::compareTo).get();
        int minValue =numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        System.out.println("minValue : "+minValue);
    }


    public static void max() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 100, 23, 93, 99);
       /* Optional<Integer> max = numbers.stream().max((a, b) -> {
            if (a > b) return 1;
            else if (a < b) return -1;
            else return 0;
        });
        if (max.isPresent()) {
            int maxValue = max.get();
            System.out.println(maxValue);
        }*/
        Integer maxValue = numbers.stream().max(Integer::compareTo).get();
        System.out.println("maxValue : "+maxValue);
    }

    public static void summaryStatics(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 100, 23, 93, 99);
        //IntSummaryStatistics intSummaryStatistics=numbers.stream().mapToInt(a->Integer.valueOf(a)).summaryStatistics();
        IntSummaryStatistics intSummaryStatistics=numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        System.out.println(intSummaryStatistics);
    }
}
