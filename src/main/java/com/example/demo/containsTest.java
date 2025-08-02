package com.example.demo;

import com.example.demo.model.ContainsModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class containsTest {
    public  static void main(String arg[]){
        ArrayList<ContainsModel>
                containsModelLList = new ArrayList<ContainsModel>();

        containsModelLList.add( new ContainsModel("Pawan",1));
        containsModelLList.add( new ContainsModel("ram",2));

        ArrayList<ContainsModel>
                containsModelLList1 = new ArrayList<ContainsModel>();

        containsModelLList1.add( new ContainsModel("krishna",8));
        containsModelLList1.add( new ContainsModel("shyam",2));

        List<ContainsModel> containsModelFiltered =
                containsModelLList.stream().filter(item-> containsModelLList1.contains(item)).collect(Collectors.toList());
//        foundObject.ifPresent(i -> i.setRollNo(1000));
//        foundObject.get().setRollNo(1000);
       System.out.println(containsModelFiltered);

      //  List<Tick> ars= ticks.stream().filter(t->instrumentTradeHistoryAvgData.contains(t)).collect(Collectors.toList());


    }
}
