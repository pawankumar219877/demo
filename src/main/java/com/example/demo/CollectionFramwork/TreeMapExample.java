package com.example.demo.CollectionFramwork;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 In order to create a TreeMap, we need to create an object of the TreeMap class.
 The TreeMap class consists of various constructors that allow the possible creation of the TreeMap.
 The following are the constructors available in this class:
 TreeMap()
 TreeMap(Comparator comp)
 TreeMap(Map M)
 TreeMap(SortedMap sm)
 */
public class TreeMapExample {
    // To show TreeMap Example
    static void TreeMapExample()
    {
        // Creating an empty TreeMap
        TreeMap<Integer, String> tree_map
                = new TreeMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        tree_map.put(70, "Geeks");
        tree_map.put(15, "4");
        tree_map.put(20, "Geeks");
        tree_map.put(25, "Welcomes");
        tree_map.put(30, "You");

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }

    // Calling constructor inside main()
    static void ExampleTreeMapWithComparator()
    {
        // Creating an empty TreeMap
        TreeMap<Student, Integer> tree_map
                = new TreeMap<Student, Integer>(
                (a,b)-> (a.getRollno()- b.getRollno()));

        // Mapping string values to int keys
        tree_map.put(new Student(111, "bbbb", "london"), 2);
        tree_map.put(new Student(131, "aaaa", "nyc"), 3);
        tree_map.put(new Student(121, "cccc", "jaipur"), 1);

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }


    // To illustrate constructor<Map>
    static void ExampleWithMapConstructor()
    {
        // Creating an empty HashMap
        Map<Integer, String> hash_map
                = new HashMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");

        // Creating the TreeMap using the Map
        TreeMap<Integer, String> tree_map
                = new TreeMap<Integer, String>(hash_map);

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }


    // Method
    // To show TreeMap(SortedMap) constructor
    static void ExampleSortedMapConstructor()
    {
        // Creating a SortedMap
        SortedMap<Integer, String> sorted_map
                = new ConcurrentSkipListMap<Integer, String>();

        // Mapping string values to int keys
        // using put() method
        sorted_map.put(10, "Geeks");
        sorted_map.put(15, "4");
        sorted_map.put(20, "Geeks");
        sorted_map.put(25, "Welcomes");
        sorted_map.put(30, "You");

        // Creating the TreeMap using the SortedMap
        TreeMap<Integer, String> tree_map
                = new TreeMap<Integer, String>(sorted_map);

        // Printing the elements of TreeMap
        System.out.println("TreeMap: " + tree_map);
    }

    // Method 2
    // LRU driver method
    public static void main(String[] args)
    {
        System.out.println("TreeMap using "
                + "TreeMap() constructor:\n");
        // To show TreeMap with empty contructor Example
     //   TreeMapExample();//TreeMap: {15=4, 20=Geeks, 25=Welcomes, 30=You, 70=Geeks}
        // To show TreeMap with contructor Example
        ExampleTreeMapWithComparator();
        // To illustrate constructor<Map>
     //   ExampleWithMapConstructor();

        // To show TreeMap(SortedMap) constructor
     //   ExampleSortedMapConstructor();
    }
}
