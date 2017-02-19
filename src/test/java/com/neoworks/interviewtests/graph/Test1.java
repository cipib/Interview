package com.neoworks.interviewtests.graph;

import java.io.IOException;

/**
 * Created by ciprian on 2/19/2017.
 */
public class Test1 {
    public static void main(String[] args) throws IOException{
        CvsFileReader cvs = new CvsFileReader();

        System.out.print("There are " + cvs.readFiles().size() + " people loaded from the file");
    }
}
