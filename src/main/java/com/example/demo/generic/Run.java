package com.example.demo.generic;

public class Run {
    public  static void main(String arg[]){
       /* GenericApplication1<Integer> gn = new GenericApplication1<Integer>(2);
        gn.showType();

        int data=gn.getObj();
        System.out.println(data); */



       /* GenericObject2 go = new GenericObject2(2);
        go.showType();

        int data1=(Integer) go.getObj();
        System.out.println(data1); */
        Integer[] arr={1,2,4,4,42,4};
        GenericSum3  intRe = new GenericSum3<>(arr);
        System.out.println(intRe.sum());

        Double[] arrDoub={1.3,2.2,4.4,4.4,42.3,4.4};
        GenericSum3  dobRe = new GenericSum3<>(arrDoub);
        System.out.println(dobRe.sum());

        if(intRe.same(dobRe)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }

        Long[] arrLng={1l,2l,4l,4l,42l,4l};
        GenericSum3  lngRe = new GenericSum3<>(arrLng);
        System.out.println(lngRe.sum());
        if(intRe.same(lngRe)){
            System.out.println("same");
        }else{
            System.out.println("not same");
        }
        /*String[] str={"1.3","2.2","4.4","4.4","42","3","4","4"};
        GenericSum3  strRe = new GenericSum3<String>(str);
        System.out.println(strRe.sum()); */



    }


}
