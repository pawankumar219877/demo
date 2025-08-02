package com.example.demo;

import java.lang.reflect.Array;
import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Programming {

    /**
     * 1. Given an array  nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
     * <p>
     * Example 1:
     * Input  :nums = [3,2,3]
     * Output: 3
     */


    public static int getMajorityNumber(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Optional<Integer> mapDta = numList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(item -> item.getValue() > (numList.size() / 2)).map(item -> item.getKey()).findFirst();

        return mapDta.get();
    }


    /**
     * 2.Find whether thesetwo string are anagram of each other or not
     * Input: str1: ‘cat’ str2:’act’
     * Output: isanAnagram
     * <p>
     * Input: str1: ‘tap’ str2:’pet’
     * Output: isnotanAnagram
     */
    public static void findAnagram(String input1, String input2) {
        char[] input1CharArray = input1.toLowerCase().toCharArray();
        Arrays.sort(input1CharArray);
        char[] input2CharArray = input2.toLowerCase().toCharArray();
        Arrays.sort(input2CharArray);
        if (Arrays.equals(input1CharArray, input2CharArray)) {
            System.out.println("isanAnagram");
        } else {
            System.out.println("isnotanAnagram");
        }
    }

    /**
     * 3.	Find whether a given two strings m and n are isomorphic.
     * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
     * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.
     * Example 1:
     * Input: s = "egg", t = "add"
     * Output: true
     * For example:
     * e -> a
     * g -> d
     * so when you replace egg it becomes add
     * Example 2:
     * Input: s = "too", t = "bar"
     * Output: false
     * <p>
     * It is false because t->b ,a -> a so the result baa != bar
     */

    public static boolean isIsomorphic(String input1, String input2) {
        char[] input1CharArray = input1.toLowerCase().toCharArray();
        char[] input2CharArray = input2.toLowerCase().toCharArray();
        int i = 0;
        String temp = new String(input1);
        Map<Character, Character> isomap = new HashMap<>();
        for (char inputChar : input1CharArray) {
            if (i < input2CharArray.length) {
                if (!isomap.containsKey(inputChar)) {
                    isomap.put(inputChar, input2CharArray[i]);
                    temp = temp.replaceAll(String.valueOf(inputChar), String.valueOf(input2CharArray[i]));

                }
            }
            if (i == (input1CharArray.length - 1)) {
                if (temp.equals(input2)) {
                    return true;
                }
            }
            i++;
        }


        return false;
    }

    /**
     * 4.	Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
     * of the characters without disturbing the relative positions of the remaining characters.
     * (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     * <p>
     * Example 1:
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     * Example 2:
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     */

    public static boolean isSubsequent(String input1, String input2) {
        char[] input1CharArray = input1.toCharArray();
        int tempIndex = -1, i = 0;
        for (char inputChar : input1CharArray) {
            int index = input2.indexOf(inputChar);
            if (index > -1) {
                tempIndex = index;

                if (index <= tempIndex) {
                    i++;
                }

            }
        }
        return (i == input1.length());
    }

    /**
     * 5.	From a given string return a longest palindrome substring.
     * <p>
     * Example 1:
     * Input: s = "babad"
     * Output: "bab"
     * Explanation: "aba" is also a valid answer.
     * <p>
     * Example 2:
     * Input: s = "cbbd"
     * Output: "bb"
     */
    public static String longestPalindrome(String input) {
        long maxCnt = 0;
        String palindrome = "";
        int i = 0, j = 1, k = 1;
        while (i < input.length()) {
            String palindromeString = getPalindrome(i, input.length(), input);
            if (palindromeString.length() > 1) {
                if (palindromeString.length() > maxCnt) {
                    maxCnt = palindromeString.length();
                    palindrome = palindromeString;
                }
            }
            i++;
        }

        while (j < input.length()) {
            String palindromeString = getPalindrome(0, input.length() - j, input);
            if (palindromeString.length() > 1) {
                if (palindromeString.length() > maxCnt) {
                    maxCnt = palindromeString.length();
                    palindrome = palindromeString;
                }
            }
            j++;
        }

        while (k < input.length() && (k < (input.length() - k))) {
            String palindromeString = getPalindrome(k, input.length() - k, input);
            if (palindromeString.length() > 1) {
                if (palindromeString.length() > maxCnt) {
                    maxCnt = palindromeString.length();
                    palindrome = palindromeString;
                }
            }
            k++;
        }

        return palindrome;
    }


    public static String getPalindrome(int i, int j, String input) {
        String inputSub = input.substring(i, j);
        char[] newChar = inputSub.toCharArray();
        String revStr = getReverse(newChar);
        return inputSub.equals(revStr) ? inputSub : "";
    }

    public static String getReverse(char[] newChar) {
        int i = newChar.length;
        char[] rev = new char[newChar.length];
        int j = 0;
        while (i > 0) {
            i--;
            rev[j] = newChar[i];
            j++;
        }

        return String.valueOf(rev);

    }

    /**
     * 6.	 Find the longest common prefix string from an array of string
     * <p>
     * If there is no common prefix, return an empty string "".
     * <p>
     * Example 1:
     * <p>
     * Input: strs = ["flowing","flown","flew"]
     * Output: "fl"
     * Example 2:
     * <p>
     * Input: strs = ["apple","night","cat"]
     * Output: ""
     * Explanation: There is no common prefix among the input strings.
     */

    public static String longestCommonPrefix(String[] strArray) {
        List<String> strList = Arrays.stream(strArray).sequential().sorted((str1, str2) -> str1.length() - str2.length()).collect(Collectors.toList());
        AtomicInteger i = new AtomicInteger(0);
        String prefix = "";
        while (i.get() < strList.get(0).length()) {
            Long cnt = strList.stream().filter(item ->
                    item.contains(String.valueOf(strList.get(0).charAt(i.get())))
                            && (item.indexOf(strList.get(0).charAt(i.get())) == i.get())

            ).collect(Collectors.counting());

            if (cnt == strList.size()) {
                prefix += String.valueOf(strList.get(0).charAt(i.get()));
            } else {
                break;
            }

            i.incrementAndGet();
        }
        return prefix;
    }


    /**
     * A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.
     * <p>
     * For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.
     * <p>
     * Write a function:
     * <p>
     * class Solution { public int solution(int N); }
     * <p>
     * that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.
     * <p>
     * For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.
     * <p>
     * Write an efficient algorithm for the following assumptions:
     * <p>
     * N is an integer within the range [1..2,147,483,647].
     * Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
     */
    public static int maxConsecutiveZeroCountInBinary(int N) {
        // write your
        Map<Integer, Integer> hsm = new HashMap<>();

        int last = -1;
        int i = 0;
        int max = 0;
        int index = 0;
        while ((N != 1) && (N != 0)) {
            int remainder = N % 2;

            if ((remainder == last) && remainder == 0) {
                if (!hsm.containsKey(i)) {
                    hsm.put(i, 1);
                } else {
                    hsm.put(i, (hsm.get(i) + 1));
                }

            } else {
                if (!hsm.containsKey(i)) {
                    if (remainder == 0) {
                        hsm.put(i, 1);
                        max = hsm.get(i);
                        last = remainder;
                    }

                }
                if (remainder == 1) {
                    i++;
                }
            }

            if (hsm.containsKey(i)) {
                if (i == 0 && (remainder == 0)) {

                } else {
                    if (hsm.get(i) > max) {
                        max = hsm.get(i);
                    }
                }

            }
            last = remainder;
            N = N / 2;

            index++;

        }
        return max;
    }

    /*
     * Complete the 'findMinimumDays' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts FLOAT_ARRAY durations as parameter.
     */

    public static int findMinimumDays(List<Float> durations) {
        // Write your code here

        float maker = 3;

        int sum = 0;
        for (int i = 0; i < durations.size(); i++) {

            float sub = maker - durations.get(i);
            durations.remove(durations.get(i));
            sum += noOfDay(sub, durations, 1);

        }
        return sum;
    }

    public static int noOfDay(float sub, List<Float> durations, int dayum) {
        Optional<Float> firstitem = durations.stream().filter(item -> item <= sub).findFirst();

        if (firstitem.isPresent()) {
            if (firstitem.get() <= sub) {
                float newsub = sub - firstitem.get();
                durations.remove(firstitem.get());
                return noOfDay(newsub, durations, dayum + 1);
            }

        }
        return dayum;
    }

    /**
     * Find the most frequently occurring character in a string
     */
    public static void largestOccurredCharacter() {
        String str = "aadsssssssfsf";

        // Count frequency using Java 8+ stream
        Map<Character, Long> frequencyMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                );

        // Find character with the maximum frequency
        Optional<Map.Entry<Character, Long>> maxEntry = frequencyMap.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue());

        maxEntry.ifPresent(entry ->
                System.out.println("Most frequent character: " + entry.getKey() + " occurred " + entry.getValue() + " times")
        );
    }

    /**
     * calculate median
     *
     * @param input
     * @return
     */
    public static double findMedian(int[] input) {
        Arrays.sort(input);
        int len = input.length;
        if (len % 2 != 0) {
            return (double) input[len / 2];
        }
        return ((double) input[(len - 1) / 2] + (double) input[(len) / 2]) / 2.0;
    }


    /**
     * @param str
     * @return
     */
    public static char findFirstNoneDuplicateChar(String str) {
        char[] charList = str.toCharArray();
        char outputChar = ' ';
        for (int i = 0; i < charList.length; i++) {

            String sub = str.replace(Character.toString(charList[i]), "");
            if (sub.indexOf(charList[i]) < 0) {
                outputChar = getOutputChar(charList[i]);
                break;
            }
        }
        return outputChar;
    }

    private static char getOutputChar(char charList) {
        char outputChar;
        outputChar = charList;
        return outputChar;
    }

    /**
     * write a program to find top 3rd largest prime number between 1 to 100 using stream api
     */
    public static void getThirdTopPrimeNumber() {
        Integer op = IntStream.iterate(100, i -> i - 1).filter(num -> {
            System.out.println(num);
            Integer cnt = (int) IntStream.range(1, num).filter(d -> num % d == 0).count();
            if (cnt == 1) {
                System.out.println("prime" + num);
            }
            return (cnt == 1);
        }).skip(2).findFirst().getAsInt();
        System.out.println(op);
        //IntStream.range(2,10).forEach(i->System.out.println(i));
    }

    public static void main(String[] arg) {
      /*  boolean isIsomorphicTest1 = isIsomorphic("egg", "add");
        System.out.println(isIsomorphicTest1);

        boolean isIsomorphicTest2 = isIsomorphic("too", "bar");
        System.out.println(isIsomorphicTest2);

        findAnagram("cat", "act");
        findAnagram("tap", "pet");

        int[] input1 = {3, 2, 3};
        int majorityNumberTestCaseOne = getMajorityNumber(input1);
        System.out.println(majorityNumberTestCaseOne);


        boolean isSubsequentTest1 = isSubsequent("abc", "ahbgdc");
        System.out.println(isSubsequentTest1);


        boolean isSubsequentTest2 = isSubsequent("axc", "ahbgdc");
        System.out.println(isSubsequentTest2);

        String[] strArray1 = {"flowing", "flown", "flew"};
        String prefixTestCase1 = longestCommonPrefix(strArray1);
        System.out.println(prefixTestCase1);


        String[] strArray2 = {"apple", "night", "cat"};
        String prefixTestCase2 = longestCommonPrefix(strArray2);
        System.out.println(prefixTestCase2);


        String longestPalindromeTestCase1 = longestPalindrome("babad");
        System.out.println(longestPalindromeTestCase1); */

       /* System.out.println("_______maxConsecutiveZeroCountInBinary_________");
         int maxConsecutive= maxConsecutiveZeroCountInBinary(328 );
        System.out.println(maxConsecutive); */
       /*   List<Float>  input= Arrays.asList(1.9f,1.04f,1.25f,2.5f,1.75f); // 3 days
        List<Float> list = new LinkedList<>(Arrays.asList(1.9f,1.04f,1.25f,2.5f,1.75f));
       //

        int op = findMinimumDays(list);

       // System.out.println(op);

        int[]  inputa= {1,2,3,4,5,6,7};
        System.out.println(findMedian(inputa));*/

        // System.out.println(findFirstNoneDuplicateChar("aaaadsdsd"));
        // getThirdTopPrimeNumber();
        String s = "pawan";
        List<String> cs = s.chars().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.toList());
        System.out.println(cs);
    }


}
