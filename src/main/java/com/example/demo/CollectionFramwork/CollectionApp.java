package com.example.demo.CollectionFramwork;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionApp {
    public static void main(String[] str) {
       /* getSortedNumberExceptFirstAndLat();
        find_second_largest_element_array_using_collection();
        find_second_largest_element_array_without_collection();
        findFrequeceyOfCharacterInAscendingOrderOfGivenString();

        findTopFifthRecordInArray();

        hasmapUsage();

        longestEvenWordLengthInString();

      findAny();

       reversWordTest();
      reverseWordInSentence();

        sortHashMapByValuesLambda();
        findMax();
        shiftOddDigitLeftAndEvenRight();
         PalindromeFinder();
        findPeakElementNotSmallerThanNeighbhors();


        findSubArrayWithGivenSum();

        shiftNegetiveDigitLeftAndEvenRight();
        shortWordInSentenceAscLengthWise();
        getRepeatedSubStringOfAgivenCountMain()
        getRepeatedSubStringOfAgivenCountUsingCollectionMain();
        */

        //  longestEvenWordInSentenceMain();
        // longestEvenWordInSentenceUsingCollectionMain();
       // findMaxProductMain();
      //  getMaxHightOfProgressiveBreaksMain();

        findPalindromInRange();
    }

    public static void getSortedNumberExceptFirstAndLat() {
        int[] array = {5, 3, 8, 2, 7, 1, 9, 4, 6}; // Example array

        int[] sortedArray = Arrays.stream(array, 1, array.length - 1)
                .sorted()
                .toArray();

        System.out.println("Sorted Array (excluding first and last elements): " + Arrays.toString(sortedArray));
    }

    public static void find_second_largest_element_array_using_collection(Integer arr[], int arr_size) {
        // Sort the array in descending order
        Arrays.sort(arr, Collections.reverseOrder());
        // Start from second element as first
        // element is the largest
        for (int i = 1; i < arr_size; i++) {
            // If the element is not
            // equal to largest element
            if (arr[i] != arr[0]) {
                System.out.printf("The second largest "
                                + "element is %d\n",
                        arr[i]);
                return;
            }
        }

        System.out.printf("There is no second "
                + "largest element\n");
    }

    public static void find_second_largest_element_array_using_collection() {
        Integer arr[] = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
        find_second_largest_element_array_using_collection(arr, n);
    }

    public static void find_second_largest_element_array_without_collection(int arr[], int arr_size) {
        int i, second;

        // There should be atleast two elements
        if (arr_size < 2) {
            System.out.printf(" Invalid Input ");
            return;
        }

        int largest = second = Integer.MIN_VALUE;

        // Find the largest element
        for (i = 0; i < arr_size; i++) {
            largest = Math.max(largest, arr[i]);
        }

        // Find the second largest element
        for (i = 0; i < arr_size; i++) {
            if (arr[i] != largest)
                second = Math.max(second, arr[i]);
        }
        if (second == Integer.MIN_VALUE)
            System.out.printf("There is no second "
                    + "largest element\n");
        else
            System.out.printf("The second largest "
                            + "element is %d\n",
                    second);
    }

    public static void find_second_largest_element_array_without_collection() {
        int arr[] = {12, 35, 1, 10, 34, 1};
        int n = arr.length;
        find_second_largest_element_array_without_collection(arr, n);
    }


    /**
     * Write a program to find the frequency of characters in a string and return result in ascending order
     * of characters.
     * Input : ashishgupta Output: a2g1h2i1p1s2t1u1
     */
    public static void findFrequeceyOfCharacterInAscendingOrderOfGivenString() {
        String inputString = "ashishgupta";
        Map<String, Long> outputMap =
                inputString.chars().mapToObj(charInt -> String.valueOf((char) charInt))
                        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        TreeMap<String, Long> sortedMap = new TreeMap<>(outputMap);
        String sortedString = sortedMap.entrySet().stream().map(item -> item.getKey() + item.getValue()).collect(Collectors.joining());
        System.out.println(sortedString);
    }

    public static void convertValueToTwoDecimalDigit() {
        //defining a number of type double
        double num = 10.98765432167;
        System.out.println("Double Number: " + num);
        //use either of the following two statements for two decimal places both gives the same result
        System.out.println("Double Number: " + String.format("%.2f", num));
        System.out.format("Double Number: %.2f", num);
    }


    public static void mergeTwoArray() {
        int[] a = new int[]{2, 3, 5, 8, 9};
        int[] b = new int[]{23, 63, 75};
        int cLength = a.length + b.length;
        int[] c = new int[cLength];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);

        Arrays.stream(c).forEach(System.out::println);
    }

    public static void findTopFifthRecordInArray() {
        int[] a = new int[]{2, 3, 5, 8, 9, 7, 7,};
        int[] b = new int[]{23, 63, 75};
        int cLength = a.length + b.length;
        int[] c = new int[cLength];
        System.arraycopy(a, 0, c, 0, a.length);
        System.arraycopy(b, 0, c, a.length, b.length);
        Integer fiftRecord = Arrays.stream(c).mapToObj(d -> (Integer) d).distinct().sorted((ab, bc) -> (bc - ab))
                .collect(Collectors.toList()).get(4);
        System.out.println(fiftRecord);
    }

    public static void hasmapUsage() {
        HashMap<Student, String> hs = new HashMap<>();
        hs.put(new Student(111, "bbbb", "london"), "a");
        hs.put(new Student(121, "aaaa", "nyc"), "v");
        hs.put(new Student(121, "aaaa", "nyc"), "d");

        System.out.println(hs);
    }


   /*Q4. Using java 8 stream Write a program to return the length of the longest word from a string
   whose length is even? */

    public static void longestEvenWordLengthInString() {
        String str = "ab abc abcd abcdef abcdefg";
        Integer max = Arrays.stream(str.split(" ")).filter(s -> ((s.length() % 2) == 0))
                .mapToInt(String::length).max().orElse(0);
        System.out.println(max);
    }

    public static void findAny() {
        Integer data = Arrays.stream(new int[]{3, 4, 5}).filter(i -> i == 3).findAny().orElse(0);
        System.out.println(data);
    }

    public static void findMax() {
        Integer max = Arrays.stream(new int[]{3, 4, 6}).max().orElse(0);
        System.out.println(max);
    }

    /*Reverse each word in string. Follow up question would be regarding punctuations, more whitespaces and gaps between words.
    Ex- "It is a good day"
    Output - "tI si a doog yad" */

    public static void reverseWordInSentence() {
        String str = "It is a good day";
        String reverseSentence = Arrays.stream(str.split(" ")).map(word -> new StringBuilder(word).reverse()).collect(Collectors.joining(" "));
        System.out.println(reverseSentence);
    }

    public static String reversWord(String str) {
        String[] strArray = str.split("");
        StringBuilder sb = new StringBuilder("");
        for (int i = (strArray.length - 1); i >= 0; i--) {
            sb.append(strArray[i]);
        }
        return sb.toString();
    }

    public static void reversWordTest() {
        String str = "pawan";
        String rev = reversWord(str);
        System.out.println(rev);
    }

    public static void sortHashMapByValuesLambda() {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Math", 9);
        hashMap.put("Data Structure", 85);
        hashMap.put("Database", 91);
        hashMap.put("Java", 95);
        hashMap.put("Operating System", 79);
        hashMap.put("Networking", 80);
        /*
         Map<String, Integer> sortedMap = hashMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(LinkedHashMap::new, (m, e) -> m.put(e.getKey(), e.getValue()), LinkedHashMap::putAll);

        sortedMap.forEach((key, value) -> System.out.println("Key = " + key + ", Value = " + value));
         */
        Map<String, Integer> hmop =
                hashMap.entrySet().stream().sorted((m1, m2) -> m2.getValue() - m1.getValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(hmop);
    }

    public static void PalindromeFinder() {
        String input = "abbaalla";
        Set<String> allPalindromes = findAllPalindromes(input);
        System.out.println("All palindromes in the text are:");
        System.out.println(allPalindromes);
    }

    public static Set<String> findAllPalindromes(String input) {
        Set<String> palindromes = new HashSet<>();
        int n = input.length();
        boolean[][] dp = new boolean[n][n];

        // Single characters are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            palindromes.add(input.substring(i, i + 1));
        }

        // Check for palindromes of length 2 or more
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (input.charAt(i) == input.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        palindromes.add(input.substring(i, j + 1));
                    }
                }
            }
        }

        return palindromes;
    }

    public static void shiftOddDigitLeftAndEvenRight() {
        int[] arr = new int[]{2, 6, 7, 9, 2, 6, 3, 5, 7, 4};
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = 0; j < arr.length; j++) {
                if ((arr[i] % 2 != 0) && (arr[j] % 2 == 0)) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    /*
      Find a peak element which is not smaller than its neighbors
      Input: array[]= {5, 10, 20, 15}
      Output: 20
      Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20.

      Input: array[] = {10, 20, 15, 2, 23, 90, 67}
      Output: 20 or 90
      Explanation: The element 20 has neighbors 10 and 15, both of them are less than 20, similarly 90 has neighbors 23 and 67.
   */
    public static void findPeakElementNotSmallerThanNeighbhors() {
        int[] arr = new int[]{10, 20, 15, 2, 23, 90, 67};
        int[] output = new int[arr.length];
        int j = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if ((arr[i] > arr[i + 1]) && (arr[i] > arr[i - 1])) {
                output[j] = arr[i];
                j++;
            }
        }
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        // using stream
        AtomicInteger i = new AtomicInteger(0);
        List<Integer> outputArr = Arrays.stream(arr).mapToObj(o -> (Integer) o).filter(item -> {
            if (i.get() == 1 || i.get() == arr.length - 2) {
                if ((arr[i.get()] > arr[i.get() - 1]) && arr[i.get()] > arr[i.get() + 1]) {
                    i.set(i.get() + 1);
                    return true;
                }
            }
            i.set(i.get() + 1);
            return false;
        }).collect(Collectors.toList());
        System.out.println(outputArr);
    }

    /**
     * Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
     * Output: Sum found between indexes 2 and 4
     * Explanation: Sum of elements between indices 2 and 4 is 20 + 3 + 10 = 33
     * <p>
     * Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
     * Output: Sum found between indexes 1 and 4
     * Explanation: Sum of elements between indices 1 and 4 is 4 + 0 + 0 + 3 = 7
     * <p>
     * Input: arr[] = {1, 4}, sum = 0
     * Output: No subarray found
     * Explanation: There is no subarray with 0 sum
     */
    public static void findSubArrayWithGivenSum() {
        int target = 33;
        int[] arr = new int[]{1, 4, 20, 3, 10, 5};
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                sum += arr[j];
                if (sum == target) {
                    System.out.println(i);
                    System.out.println(j);
                }
            }
        }
    }

    public static void shiftNegetiveDigitLeftAndEvenRight() {
        int[] arr = new int[]{-12, 11, -13, -5, 6, -7, 5, -3, -6};
        int temp = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            if (arr[i] < 0) {
                if (i != j) {
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void shortWordInSentenceAscLengthWise() {
        String str = "My name is pawan";
        List<String> strList =
                Arrays.stream(str.split(" ")).sorted((s1, s2) -> s1.length() - s2.length()).collect(Collectors.toList());
        System.out.println(strList);
    }


    /*
     Input: ASEERRRRFFFCSSHHHTTTTDDF, 4	Output: RRRR,TTTT
     Input: ASEERRRRFFFCSSHHHTTTTDDF, 2	Output: EE,SS,DD
     String str = "ASEERRRRFFFCSSHHHTTTTDDF";
     */
    public static void getRepeatedSubStringOfAgivenCountMain() {
        String Input = "ASEERRRRFFFCSSHHHTTTTDDF";
        String[] str = getRepeatedSubStringOfAgivenCount(Input, 2);
        Arrays.stream(str).forEach(System.out::println);
    }

    public static String[] getRepeatedSubStringOfAgivenCount(String inputStr, Integer reqLen) {
        String[] op = new String[inputStr.length()];
        char[] charArr = inputStr.toCharArray();
        char[] bufferCharArray = new char[inputStr.length()];
        int count = 0;
        char lastChar = charArr[0];
        int opCount = 0;
        String suStr = String.valueOf(lastChar);
        for (int i = 0; i < charArr.length; i++) {
            bufferCharArray[i] = charArr[i];
            if (lastChar == charArr[i]) {
                if (contains(bufferCharArray, charArr[i])) {
                    if (i > 0) {
                        suStr += String.valueOf(charArr[i]);
                    }
                    count++;
                }
                if (count == reqLen) {
                    op[opCount] = suStr;
                    opCount++;
                }
            } else {
                count = 1;
                suStr = String.valueOf(charArr[i]);
            }
            lastChar = charArr[i];
        }
        return op;
    }

    public static boolean contains(char[] bufferCharArray, char character) {
        for (int i = 0; i < bufferCharArray.length; i++) {
            if (bufferCharArray[i] == character) {
                return true;
            }
        }
        return false;
    }

    public static void getRepeatedSubStringOfAgivenCountUsingCollectionMain() {
        String Input = "ASEERRRRFFFCSSHHHTTTTDDF";
        Integer reqLen = 4;
        List<String> op =
                Input.chars().mapToObj(intStr -> String.valueOf((char) intStr))
                        .collect(Collectors.groupingBy(Function.identity()))
                        .entrySet().stream().filter(data -> data.getValue().size() == reqLen)
                        .flatMap(item -> Stream.of(item.getValue().stream().collect(Collectors.joining(""))))
                        .collect(Collectors.toList());
        System.out.println(op);
    }


    /*
          String str ="adc dfdsf djdjdjfkk aaaaa vvvv";

      Map<String,Integer> mapdata= Arrays.stream(str.split(""))
               .map(mapitem->new HashMap<String,Integer>().put(mapitem,mapitem.length()))
              .collect(Collectors.toMap(String.class,Integer.class));
     */

    /**
     * Write a function to return the longest even length word in a sentence.
     * Sample input: Be not afraid of greatness, some are born great, some achieve greatness,
     * and some have greatness thrust upon them.
     * Output: afraid
     */

    public static void longestEvenWordInSentenceMain() {
        String inputString = "Be not afraid of greatness some are born great, some achieve greatness,and some have greatness thrust upon them.";
        String outputString = longestEvenWordInSentence(inputString);
        System.out.println(outputString);
    }

    public static String longestEvenWordInSentence(String inputString) {
        String[] strArray = inputString.split(" ");
        String outputString = "";
        Integer maxLength = 0;
        for (int i = 0; i < strArray.length; i++) {
            if ((strArray[i].length() % 2 == 0) && (strArray[i].length() > maxLength)) {
                maxLength = strArray[i].length();
                outputString = strArray[i];
            }
        }
        //(inputString)
        return outputString;
    }

    public static void longestEvenWordInSentenceUsingCollectionMain() {
        String inputString = "Be not afraid of greatness some are born great, some achieve greatness,and some have greatness thrust upon them.";
        String longestString = longestEvenWordInSentenceUsingCollection(inputString);
        System.out.println(longestString);
    }

    public static String longestEvenWordInSentenceUsingCollection(String inputString) {
        return Arrays.stream(inputString.split("\\s+"))
                .filter(word -> word.length() % 2 == 0)
                .max(Comparator.comparingInt(String::length))
                .orElse(null);
    }

    /**
     * Write an efficient  java function to find a pair with maximum . product In array of Integers,
     * Given an array with both +ve   and -ve integers, return a pair with highest product
     * Examples: ,r with highest product
     * Examples: Input: arr[] = {l, 8, 3, 6, 7 , 0}  o/p {8,7}       input: arr[] :{-1,-3,-6,3,0,-5} o/p {-6,-5}
     */

    public static void findMaxProductMain() {
        int[] data1 = new int[]{1, 8, 3, 6, 7, 0};
        int[] p1 = findMaxProduct(data1);
        Arrays.stream(p1).forEach(System.out::println);

        int[] data2 = new int[]{-1, -3, -6, 3, 0, -5};
        int[] p2 = findMaxProduct(data2);
        Arrays.stream(p2).forEach(System.out::println);
    }

    public static int[] findMaxProduct(int[] arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > firstMax) {
                secondMax = firstMax;
                firstMax = arr[i];
            } else if (arr[i] > secondMax) {
                secondMax = arr[i];
            }

            if (arr[i] < firstMin) {
                secondMin = firstMin;
                firstMin = arr[i];
            } else if (arr[i] < secondMin) {
                secondMin = arr[i];
            }
        }
        int product1 = firstMax * secondMax;
        int product2 = firstMin * secondMin;
        if (product1 > product2) {
            return new int[]{firstMax, secondMax};
        } else {
            return new int[]{firstMin, secondMin};
        }
    }

    /**
     * Write a function to find maximum height of a staircase
     * Given N number of square blocks the task is to create a staircase of max height using these
     * blocks. The first stair would require only one block, the second stair would require two
     * blocks and so on.
     * input  o/p
     * 10      4
     * 12      4
     * 16      5
     */
    public static void getMaxHightOfProgressiveBreaksMain() {
        int height = getMaxHightOfProgressiveBreaksMain(16);
        System.out.println(height);
    }

    public static int getMaxHightOfProgressiveBreaksMain(int Sum) {
        int i = 1;
        int h = 0;
        while (i < Sum) {
            if (((i * i) + i) <= 2*Sum) {
                h++;
            } else {
                break;
            }
            i++;
        }
        return h;
    }

    public static void findPalindromInRange(){
        for (int i = 100000; i <= 999999; i++) {
           /* String strInt = String.valueOf(i);
            int mid= (strInt.length()/2) ;
            String rev = String.valueOf(new StringBuilder(strInt).reverse());
            if(rev.equals(strInt)){
                System.out.println(strInt);
            } */
            int reverseDigit = 0;
            int digit = i;
            while (digit > 0) {
                int remender = digit % 10;
                reverseDigit = reverseDigit * 10 + remender;
                digit = digit / 10;
            }
            if (reverseDigit == i) {
                System.out.println(i);
            }
        }
    }
}
