package com.example.demo;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternTest1 {
    public static void main(String arg[]){
        Scanner scan = new Scanner(System.in);
        String a=new String("ddd");
        int i = scan.nextInt();
        Double d = scan.nextDouble();

        String s1=scan.nextLine();
        String s2=scan.nextLine();

//        while(scan.hasNextLine()){
//            //Print the contents of a file by line
//           s.concat(scan.nextLine())  ;
//        }


                //.replace(Integer.toString(i), "").replace(Double.toString(d), "").replace(" ", "");
       System.out.println("String: " + s2);
        HashMap<String,String> sa= new HashMap<>();
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);

      /*  String s= "Welcome to HackerRank's Java tutorials!";
        Pattern  pattern= Pattern.compile("Welcome");
        boolean m=pattern.matcher(s).matches();
        System.out.println(m); */
    }
}
