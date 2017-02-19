package com.neoworks.interviewtests.graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ciprian on 2/19/2017.
 */
public class CvsFileReader {
    public static List<Person> People = new ArrayList<>();

    private static Person findPerson(String email, List<Person> People) {
        for(Person p : People)
            if(p.email.equals(email))
                return p;
        return new Person("");
    }

    public static List<Person> readFiles() throws IOException {
        String peopleFile = "F:\\Interview\\src\\test\\resources\\people.csv";
        String relationshipFile = "F:\\Interview\\src\\test\\resources\\relationships.csv";
        String line = "";
        String separator = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(peopleFile));
            while ((line = br.readLine()) != null) {
                String[] people = line.split(separator);
                if(!line.isEmpty()) {
                    Person p = new Person(people[1]);
                    p.name = people[0];
                    p.age = Integer.parseInt(people[2]);
                    People.add(p);
//                    System.out.print(p.name +" "  +p.email + "\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader((relationshipFile)));
            while((line = br.readLine()) != null) {
                String[] relation = line.split(separator);
                if(!line.isEmpty())
                    for(Person p :People) {
                        if(p.email.equals(relation[0]))
                           p.relations.put(findPerson(relation[2], People), relation[1]);
                        if(p.email.equals(relation[2]))
                           p.relations.put(findPerson(relation[0], People), relation[1]);
                    }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        for(Person p:People) {
//            System.out.print(p.name + p.relations);
//        }
        return People;
    }

    public static int familySize(Person p) {
        int i = 1;
        for(Map.Entry<Person, String> entry: p.relations.entrySet()) {
            if(entry.getValue().equals("FAMILY"))
                i++;
        }
        return i;
    }
}
