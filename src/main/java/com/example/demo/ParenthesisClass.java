package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParenthesisClass {



    public  static boolean  hasRevChar(String str){
        String[] lit={"{}","()","[]"};

        for(int i=0; i<str.length();i++){

            for(int j=0; j<lit.length;j++){
                if( str.indexOf(lit[j])>-1){
                    str=str.replace(lit[j],"");
                }

            }


        }

        return  str.equals("");
    }

    public static void main(String args[]) throws Exception {


        String str= "[{[]}]()";
        System.out.println(hasRevChar(str));



    }
}
