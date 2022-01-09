package com.hasithat.main;


import com.hasithat.beans.Person;
import com.hasithat.mockdata.MockData;

import java.util.List;
import java.util.stream.Collectors;

public class HowStreamsWork {

    public static void understandingCollect() throws Exception {
        List<String> emails = MockData.getPeople()
                .stream()
                .map(Person::getEmail)
                .collect(Collectors.toList());

        emails.forEach(System.out::println);
    }


    public static void main(String[] args) {
        try {
            understandingCollect();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
