package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class OptumTest {
    public static int solution(String S, int[] C) {
        // write your code in Java SE 8
        HashMap<Integer, HashMap<String, List<Integer>>>  mapData=    new HashMap<>();



        HashMap<String, List<Integer>> data= new HashMap<>();
        int i=0;
         String temp="";

       int d=0;
        for(char itemChar  : S.toCharArray()){

            String charStr=String.valueOf(itemChar);
            HashMap<String, List<Integer>> values= new HashMap<>();
            if(i==0){
                List<Integer> dataList= new ArrayList<>();
                dataList.add(C[i]);
                temp=charStr;
                values.put(charStr,dataList);
                mapData.put(d,values);
            }else{
                if(!temp.equals(charStr)){
                    List<Integer> dataList= new ArrayList<>();
                    dataList.add(C[i]);
                    temp=charStr;
                    values.put(charStr,dataList);
                    mapData.put(d,values);
                    d++;
                }else{
                    if(mapData.get(d).get(charStr).size()==2){
                        d++;
                    }else {
                        mapData.get(d).get(charStr).add(C[i]);
                    }

                }
            }

        i++;

        }
      /*  for(char itemChar  : S.toCharArray()){

            String charStr=String.valueOf(itemChar);
            HashMap<String, List<Integer>> values= new HashMap<>();
            if(i%2==1){
                if(!mapData.containsKey(i)){
                    mapData.put(i,values);
                }
            }

            int j=0;
            for( Map.Entry<Integer, HashMap<String, List<Integer>>>  mData : mapData.entrySet()){
                HashMap<String, List<Integer>> item =mData.getValue();
                if(item.containsKey(charStr)){
                    if((item.get(charStr).size()<3)){
                        item.get(charStr).add(C[i]);
                    }
                }else {
                    List<Integer> dataList= new ArrayList<>();
                    dataList.add(C[i]);
                    values.put(charStr,dataList);
                }
                j++;
            }
            i++;

        } */
        int sum=0;
        for( Map.Entry<Integer, HashMap<String, List<Integer>>>  mData : mapData.entrySet()){
            HashMap<String, List<Integer>> values= mData.getValue();
            for( Map.Entry<String, List<Integer>>  entrydata : values.entrySet()){
                if(entrydata.getValue().size()>1){
                    Integer minData=  entrydata.getValue().stream().min(Integer::compare).get();
                    sum+=minData;
                }
            }

        }


         return sum;
    }
//    public static int solution(int[] A) {
//        // write your code in Java SE 8
//        Arrays.sort(A);
//        int min=1;
//
//        for(int i=0;i<A.length;i++){
//            if((i+1)<A.length){
//                if(A[i]<A[i+1]){
//                    if(A[i+1]-A[i]==2){
//                        min =A[i]+1;
//                    }
//                }else{
//
//                }
//
//            }
//
//        }
//        return min;
//    }


    public static  void main(String[] arg){
//        int[] arr= {-2,-3,1};
//        int op = solution(arr);
//        System.out.println(op);


        int[] c= {3,4,5,6};
        int op= solution("aaaa", c);

        System.out.println(op);

    }
}
