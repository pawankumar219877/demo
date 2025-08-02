package com.example.demo.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class sortInteger {
    public static void main(String[] args) {
        shortCharacterOfStringInArrayList();
    }

    public static void shortElementleavingFirstAndLastElement() {
        List<Integer> li = Arrays.asList(111, 56, 1, 34, 19, 1, 8, 3, 0);
        List op = li.stream().filter(item -> !(item.equals(li.get(0))) && !(item.equals(li.get(li.size() - 1)))).sorted((a, b) -> a.compareTo(b)).collect(Collectors.toList());
        System.out.println(op);
    }

    public static void shortElementleavingFirstAndLastElementUsingNativeCode() {
        int[] data = {57, 45, 56, 78, 34, 23, 10};
        List<Integer> list = new ArrayList<>();
        int temp;
        for (int i = 1; i < data.length - 1; i++) {
            for (int j = 1; j < data.length - 1; j++) {
                if (data[j] >= data[i]) {
                    temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }

    public static void shortCharacterOfStringInArrayList() {
        List<String> li = Arrays.asList("pawan", "ram", "shyam");

        List<String> op =
                li.stream().map(item -> item.chars()
               .mapToObj(c->String.valueOf((char) c)).sorted().collect(Collectors.joining("")))
                        .collect(Collectors.toList());

        System.out.println(op);
    }
}
