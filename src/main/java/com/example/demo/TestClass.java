package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        String[] str= name.split("");
        Integer n =  Integer.valueOf(str[0]);
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
    }

}
