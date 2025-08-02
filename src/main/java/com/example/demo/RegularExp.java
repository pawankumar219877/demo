package com.example.demo;

import java.util.regex.Pattern;

public class RegularExp {
    public static void main(String[] arg) {
        Boolean b = Pattern.matches("^(\\s+//.*|//.*)","        // Using Stream flatMap(Function mapper)");

        Boolean c = Pattern.matches("^(\\s+/\\*|/\\*)","/*");

        Boolean d = Pattern.matches("(.*\\*/)$","*/");

        Boolean space = Pattern.matches("(.*\\*/)$","*/");
        System.out.println(b);
    }
}
