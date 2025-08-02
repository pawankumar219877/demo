package com.example.demo.CollectionFramwork;

import java.util.HashSet;
import java.util.Set;

public class SumPairs {
    public static void main(String[] args) {
                  // 5  1  -1  7  1   -6
        int[] arr = { 1, 5, 7, -1, 5,12};
        int target = 6;

        Set<Pair> result = findPairs(arr, target);

        System.out.println("Distinct pairs with sum " + target + ":");
        for (Pair pair : result) {
            System.out.println(pair);
        }
    }

    static Set<Pair> findPairs(int[] arr, int target) {
        Set<Pair> pairs = new HashSet<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) { // 1  , 5 ,  7
            int complement = target - num;  //6-1=5 , 1, -1
            if (seen.contains(complement)) {  // false  yes  false
                pairs.add(new Pair(num, complement));
            }
            seen.add(num);//seen=1 seen=1,5
        }

        return pairs;
    }
}
