package com.example.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class Distinct {
    public static void main(String arg[]){
        int[] ar= { 9, 5,7,7,8,9};
        distintArray(ar);

    }

  public static   int[]  distintArray( int[] ar){


   
      List<Integer> list= new ArrayList<>();
      List<Integer> dis= new ArrayList<>();
      for(int data : ar){
          if(!list.contains(data)){
              list.add(data);
          }else{
              dis.add(data);
          }
      }

      dis.sort(( a, b)-> a-b);
      int[] op = new  int[dis.size()];
      int j=0;
      for(int data  : dis){
          op[j]=  dis.get(j);
          j++;
      }

      return  op;
  }



}
