package com.hasithat.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningStrings {

    public static void main(String[] args) {
        try {
            joiningStringsWithStream();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void joiningStringsWithStream() throws Exception {
        List<String> names = Arrays.asList("anna", "john", "marcos", "helena", "yasmin");
        String joinedString = names.stream().collect(Collectors.joining(","));
        System.out.println("joinedString " + joinedString);


    }

}
