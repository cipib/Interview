package com.neoworks.interviewtests.graph;

import java.util.HashMap;

/**
 * Created by ciprian on 2/19/2017.
 */
public class Person {
    public String name;
    public String email;
    public int age;
    public HashMap<Person, String> relations = new HashMap<>();

    public Person(String email) {
        this.email = email;
    }

    public String toString() {
        return name;
    }
}
