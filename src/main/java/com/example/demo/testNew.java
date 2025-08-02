package com.example.demo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class testNew {
    public  static void main(String[] arg){


        String str= "hello world hello";
       char[] list= str.toCharArray();

       for(int i=0; i<list.length;i++){
           int j=str.indexOf(list[i]);
           if( (str.indexOf(list[i])>-1) && (i==j)   ){
               System.out.println(list[i]);

           }else{



           }

       }







    }
}



