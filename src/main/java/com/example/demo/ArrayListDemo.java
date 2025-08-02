package com.example.demo;

import com.example.demo.model.ArrayListDemoModel;

import java.util.ArrayList;
import java.util.Optional;

public class ArrayListDemo {

    public  static void main(String arg[]){
        ArrayList<ArrayListDemoModel>
                arrayListDemoModelLList = new ArrayList<ArrayListDemoModel>();

        arrayListDemoModelLList.add( new ArrayListDemoModel("Pawan",1));
        arrayListDemoModelLList.add( new ArrayListDemoModel("ram",2));

        Optional<ArrayListDemoModel> foundObject =
                arrayListDemoModelLList.stream().filter(item-> item.getRollNo().equals(1)).findFirst();
        foundObject.ifPresent(i -> i.setRollNo(1000));
        foundObject.get().setRollNo(1000);
        System.out.println(arrayListDemoModelLList);

    }
}
