package com.example.demo.generic;
//Bounded Type
public class GenericSum3<T extends Number> {
    T[] arrObj;
    GenericSum3(T[] arr){
        this.arrObj=arr;
    }

    public double sum(){
        double op = 0;
        for (int i=0;i<arrObj.length;i++){
            op=op+arrObj[i].doubleValue();
        }
        return op;
    }
   // wildcard argument
    public boolean same(GenericSum3<?> ob){
        if(sum()==ob.sum()){
            return true;
        }
        return false;
    }

}
