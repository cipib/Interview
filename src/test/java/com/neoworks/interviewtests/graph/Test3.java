package com.neoworks.interviewtests.graph;

import java.io.IOException;
import java.util.List;

/**
 * Created by ciprian on 2/19/2017.
 */
public class Test3 {

    public static void main(String[] args) throws IOException {
        CvsFileReader cvs = new CvsFileReader();
        List<Person> People = cvs.readFiles();
        for(Person p: People)
//            if(p.name.equals("Jenny") || p.name.equals("Bob"))
            System.out.print(p.name + " (" + cvs.familySize(p) + " family members) \n");
    }
}
