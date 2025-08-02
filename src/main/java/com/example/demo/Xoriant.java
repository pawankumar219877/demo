package com.example.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xoriant {

    public  static Map<Character,Integer> maxRepeated(String str){
        char[] charlist= str.toCharArray();

        Map<Character,Integer> map= new HashMap<>();

        Map<Character,Integer> opmax= new HashMap<>();
        char op=charlist[0];
        Integer biggest=0;
        for(int i=0;i<charlist.length;i++){

            if(!map.containsKey(charlist[i])){
                map.put(charlist[i],1);
            }else{
                Integer  maxCount= (map.get(charlist[i])+1);
                map.put(charlist[i],maxCount);
                if( maxCount>  biggest){
                    biggest=maxCount;
                    op= charlist[i];
                    opmax.put(op,biggest);
                }

            }
        }
      return  opmax;
    }

    public  static void main(String[] arg){


//            String str= "aaaappalarajju";
//
//
//            List abd= Arrays.asList(1,2,3);
//           abd.stream().filter(x->{ return (x%2==1) }).map(x-> { return x=x*x; }  ).sum();
//
//           System.out.println(maxRepeated(str));





    }



}
