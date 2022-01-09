package com.hasithat.main;


import com.hasithat.beans.Car;
import com.hasithat.beans.Person;
import com.hasithat.mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sorting {

    public static void main(String[] args) {
        try {
            sortingSteamOfElementsDefaultWay();
            System.out.println("******************************");
            sortingSteamOfElements();
            System.out.println("******************************");
            sortingSteamOfElementsReverse();
            System.out.println("******************************");
            sortingSteamOfObjetsUsingMoreThanOneCondition();
            System.out.println("******************************");
            topTenMostExpensiveBlueCars();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //This given an run time exception since  sorting field is not defined.
    public static void sortingSteamOfElementsDefaultWay() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> defaultSortedPeopleList = people.stream().sorted().collect(Collectors.toList());
        defaultSortedPeopleList.forEach(person -> System.out.println(person));

    }

    public static void sortingSteamOfElements() throws IOException {
        List<Person> people = MockData.getPeople();
        //1 st way
        /*List<Person> sortByAge = people.stream().sorted((p1, p2)->p1.getAge().compareTo(p2.getAge())).collect(Collectors.toList());
        sortByAge.forEach(person-> System.out.println(person));*/
        //2 nd way
        List<Person> sortByAgeAnotherWay = people.stream().sorted(Comparator.comparing(p -> p.getAge())).collect(Collectors.toList());
        sortByAgeAnotherWay.forEach(person -> System.out.println(person));


    }


    public static void sortingSteamOfElementsReverse() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sortedPeopleReversedAge = people.stream().sorted(Comparator.comparingInt(Person::getAge).reversed()).collect(Collectors.toList());
        sortedPeopleReversedAge.forEach(System.out::println);
    }


    public static void sortingSteamOfObjetsUsingMoreThanOneCondition() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> sortedPeopleListByAgeAndFirstName = people.stream().sorted(Comparator.comparing(Person::getAge).thenComparing(Person::getFirstName)).collect(Collectors.toList());
        sortedPeopleListByAgeAndFirstName.forEach(System.out::println);
    }


    public static void topTenMostExpensiveBlueCars() throws IOException {
        List<Car> cars = MockData.getCars();
        Stream<Car> topTenMostExpensiveBlueCars = cars.stream().filter(car -> car.getColor().equalsIgnoreCase("Blue")).sorted(Comparator.comparing(Car::getPrice).reversed()).limit(10);
        topTenMostExpensiveBlueCars.forEach(car -> System.out.println(car));

    }

}
