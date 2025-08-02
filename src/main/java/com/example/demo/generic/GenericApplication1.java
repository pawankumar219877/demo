package com.example.demo.generic;

public class GenericApplication1<T> {
    T obj;

    public GenericApplication1(T o) {
        this.obj = o;
    }


    T getObj() {
        return this.obj;
    }

    void showType() {
        System.out.println(obj.getClass().getName());
    }

}
