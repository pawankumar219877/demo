package com.example.demo.generic;

public class GenericObject2 {
    Object obj;
    GenericObject2(Object o){
        this.obj=o;
    }

    Object getObj(){
        return obj;
    }

    void showType() {
        System.out.println(obj.getClass().getName());
    }
}
