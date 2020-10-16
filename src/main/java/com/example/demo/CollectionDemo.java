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


         List<Student>   getonlybranch=  st.stream().map(Student::getBranch).collect(Collectors.asList());
         System.out.println(st);

        String str[] = { "dsd","dsfsg", "efqwrqwr" };
        List<String> l = new Arrays.asList("one", "two");
        String version = System.getProperty("java.version");

        System.out.println(version);

    }

}
