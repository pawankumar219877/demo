package com.example.demo;

import java.util.Arrays;

public class ScopeTest {

    public Integer i = 0;


    public static void main(String[] args) {
       /* ScopeTest hw = new ScopeTest();
        hw.run(); */

        Integer stockTradeCap =Integer.parseInt("5");
        String[] weightageList = new String[stockTradeCap] ;
        Integer stockTradeCapClone = stockTradeCap;
        for (Integer i=0;i<stockTradeCap; i++){
            weightageList[i]=String.valueOf(stockTradeCapClone);
            stockTradeCapClone--;
        }
    System.out.println(Arrays.stream(weightageList).toArray());
    }


    public  void  run (){
        i++;
        System.out.println("before i =" + i);
        increment(i);
        System.out.println("after i =" + i);
    }

    public  void increment(Integer index){
        index++;
    }
}
