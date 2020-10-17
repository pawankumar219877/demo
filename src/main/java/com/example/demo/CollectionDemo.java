package com.example.demo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.*;


public class CollectionDemo {
    Student student;
    public  static  void main (String arg[]){

        //  CommonBuilder<Student>   student   = new CommonBuilder<Student>(student).withName("Pawan").withBranch("CSE").withContactNo("8147152268").buid();
        Student  student[]   ={
                new StudentBuilder()
                        .withName("Pawan").withBranch("CSE").withContactNo("8147152268").build(),
                new StudentBuilder()
                        .withName("Ram").withBranch("It").withContactNo("4242152268").build(),
                new StudentBuilder()
                        .withName("Shyam").withBranch("EEE").withContactNo("3252352353").build()

        };

        List<Student> st= new ArrayList<>();
        st.add(student[0]);
        st.add(student[1]);
        st.add(student[2]);


        List<String>   getonlybranch=  st.stream().map(Student::getBranch).collect(Collectors.toList());
        System.out.println(getonlybranch);




        /*List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);
        //   System.out.println(st);
        String str[] = { "dsd","dsfsg", "efqwrqwr" };
        Integer a[] = new Integer[] { 10, 20, 30, 40 };
        // getting the list view of Array
        List<Integer> list = Arrays.asList(a);
        String version = System.getProperty("java.version");
        System.out.println(list);
        System.out.println(version);  */

    }

}
