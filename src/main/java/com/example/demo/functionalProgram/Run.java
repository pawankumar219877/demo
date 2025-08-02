package com.example.demo.functionalProgram;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Run {
    public static void main(String[] arg){
        FunctionalInterfaceExample b =(str)->str.equals("pawan");
        System.out.println(b.checkVowel("pawan"));

        functionIdentityUsage1();
        functionIdentityUsage2();
    }
    public static void functionIdentityUsage1(){
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        Map<String, String> fruitMap = fruits.stream()
                .collect(Collectors.toMap(Function.identity(), fruit -> fruit));
        System.out.println(fruitMap);
    }
    public static void functionIdentityUsage2(){
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry");
        Map<String, Long> frequencyCount = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
         System.out.println(frequencyCount);
    }
 }

