package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.stream.Collectors;

public class HrBufferedReader {
    /**
     *
     */

    public static int minimumMoves(List<Integer> arr1, List<Integer> arr2) {
        // Write your code here
        int min =0;
        for( int i=0 ;i <arr1.size();i++ ){
            String str1= String.valueOf(arr1.get(i));
            String str2= String.valueOf(arr2.get(i));

            char[] strChar1= str1.toCharArray();
            char[] strChar2= str2.toCharArray();
            int sum=0;
            for( int j=0 ;j <strChar1.length;j++ ){
                int dif= Math.abs(Integer.valueOf(strChar1[j])-Integer.valueOf(strChar2[j]));
                sum= sum+dif;

            }
            if(i==0){
                min=  sum;
            }

            if(sum<min){
                min= sum;
            }


        }
        return min;
    }

    static long solve(long num){
        // Write your code here
        long decrementTrial= belowNumberTrial( num);
        long incrementTrial= incrementNumberTrial( num);
        if(decrementTrial<incrementTrial){
            return decrementTrial;
        }else{
            return incrementTrial;
        }
    }

    public static long belowNumberTrial(long num){
        long tempNum= num;
        long trial=0;
        long outputTrial=0;
        while(tempNum!=0){
            boolean palindrom= isPalindrom(tempNum);
            if(palindrom){
                outputTrial=trial;
                break;
            }

            tempNum--;
            trial++;
        }
        return outputTrial;
    }


    public static long incrementNumberTrial(long num){
        long tempNum= num+1;
        long trial=1;
        long outputTrial=1;
        while(tempNum<=100000){
            boolean palindrom= isPalindrom(tempNum);
            if(palindrom){
                outputTrial=trial;
                break;
            }

            tempNum++;
            trial++;
        }
        return outputTrial;
    }

    public static boolean isPalindrom(long num){
        List<Long> binary = new ArrayList<>();
        while(num!=1){
            binary.add(num%2);
            num=num/2;
            if(num==1){
                binary.add(1l);
                break;
            }

        }
        String original = binary.stream().map(d->Long.toString(d)).collect(Collectors.joining(""));
        Collections.reverse(binary);
        String reverse = binary.stream().map(d->Long.toString(d)).collect(Collectors.joining(""));

        return original.equals(reverse);

    }


    public static void main(String arg[]){



      long op=   solve(23);

        System.out.println(op);

//        List arr1 = new ArrayList<>();
//        arr1.add(1234);  //1 1 11
//        arr1.add(4321);   // 1113
//
//
//        List arr2 = new ArrayList<>();
//        arr2.add(2345);
//        arr2.add(3214);
//
//        int a= minimumMoves(arr1, arr2);
//        System.out.println(a);


















//        Scanner sc=new Scanner(System.in);
//        System.out.println("================================");
//        for(int i=0;i<3;i++){
//            String s1=sc.next();
//            int x=sc.nextInt();
//            //Complete this line
//
//            String xStr=Integer.toString(x);
//            while (xStr.length()<3){
//                xStr= "0"+xStr;
//            }
//
//
//            while (s1.length()<15){
//                s1= s1+" ";
//            }
//
//
//            System.out.println(s1+xStr);
//        }
//        System.out.println("================================");
    }
}
