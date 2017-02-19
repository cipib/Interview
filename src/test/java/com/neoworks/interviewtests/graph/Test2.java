package com.neoworks.interviewtests.graph;

import java.io.IOException;
import java.util.List;

/**
 * Created by ciprian on 2/19/2017.
 */
public class Test2 {

    public static void main(String[] args) throws IOException {
        CvsFileReader csv = new CvsFileReader();
        List<Person> People = csv.readFiles();
        for(Person p : People) {
            // Was not sure if you want me to show the relationships just for those for people
            // If added, the if statement would only show the 4 people in the example
            //if(p.name.equals("Bob") || p.name.equals("Jenny") || p.name.equals("Nigel") || p.name.equals("Alan") )
                System.out.print(p.name + " (" + p.relations.size() + " relationships)" + "\n");
        }
    }
}
