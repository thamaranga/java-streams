package com.hasithat.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByEx {

    public static void main(String[] args) {
        List<Person> people= new ArrayList<>();
        people.add(new Person(30, "Hasitha"));
        people.add(new Person(40, "Nipuna"));
        people.add(new Person(50, "Miran"));
        people.add(new Person(30, "Amila"));
        people.add(new Person(40, "Sunil"));
        people.add(new Person(45, "Kumara"));

        Map<Integer, List<Person>> groupByAge = people.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(groupByAge);

    }




}


class Person{

    private int age;
    private String name;

    public Person(int age, String name){
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name+" | "+age;
    }
}