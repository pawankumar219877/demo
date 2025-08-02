package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ScannerTest {



    public static void main(String[] arg){

        Scanner in = new Scanner(System.in);

        int a = in.nextInt();
        System.out.println("No ofInput " + a);
         in.nextLine();



        for(int i=0;i< a;i++){
            String s = in.nextLine();
            String[] str= s.split(" ");

            Integer peopleNo= Integer.valueOf(str[0]);
            Integer minVote= Integer.valueOf(str[1]);
            System.out.println("peopleNo " + peopleNo);
            System.out.println("minVote " + minVote);

          String inputStr = in.nextLine();
          String[] listStr= inputStr.split(" ");
            if(listStr.length>=peopleNo){
                in.nextLine();
            }
          Integer setSize =Arrays.stream(listStr).collect(Collectors.toSet()).size();

            System.out.println("setSize " + setSize);
           if(setSize<minVote){
               System.out.println("RAMYA");
           }else{
               System.out.println("JANI");
           }


        }



//        String s = in.nextLine();
//        System.out.println("You entered string " + s);
//
//        int a = in.nextInt();
//        System.out.println("You entered integer " + a);
//
//        float b = in.nextFloat();
//        System.out.println("You entered float " + b);
    }

}
