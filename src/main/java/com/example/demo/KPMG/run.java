package com.example.demo.KPMG;

import java.util.Scanner;

public class run {
    public static void main(String[] arg){
        Scanner scn = new Scanner(System.in);
        int[] arrayInt = new int[11];
        int i=0;
        while (scn.hasNext() && i<10){
            arrayInt[i] = scn.nextBigInteger().intValue();
            i++;
        }
        Cricket cr =new Cricket(arrayInt);
        Football ft =new Football(arrayInt);
    }

}
