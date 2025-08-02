package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Anagrams {

    public static String returnAnagram(String str) {
        List<Character> chardd = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        char[] charList = str.toCharArray();

        Arrays.sort(charList);

//        CharStream chars= Arrays.stream(charList);
        String Str = "";
        for (char i : charList) {
            Str += i;
        }

        return Str;
    }


    public static void main(String[] arg) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<String> list = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");

        List<List<String>> op = new ArrayList<>();

        list.stream().forEach(item -> {

            List<String> anagram = new ArrayList<>();

            String sorted = returnAnagram(item);
            if (list.contains(sorted)) {
                anagram.add(item);
                anagram.add(sorted);

            }

        });

        System.out.println(op);

    }
}
