package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Pattern;

public class LineCounter {
    public static void main(String[] arg) {
        String filePath = "D:\\SHM_WorkSpace\\testDemo\\src\\main\\java\\org\\example\\test2.java";
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Integer linCount = 0;
            while ((line = br.readLine()) != null) {
                Boolean commentInline = Pattern.matches("^(\\s+//.*|//.*)",line);
                Boolean commentMultiLineStart = Pattern.matches("^(\\s+/\\*|/\\*)",line);
                Boolean commentMultiLineEnd = Pattern.matches("(.*\\*/)$",line);
                if (commentInline || commentMultiLineStart || commentMultiLineEnd || line.trim().isEmpty()) {
                } else {
                    System.out.println("line ="+line);
                    linCount++;
                }
            }
            System.out.println(linCount);
        } catch (Exception e) {
        }
    }


}