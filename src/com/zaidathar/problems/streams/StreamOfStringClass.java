package com.zaidathar.problems.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamOfStringClass {
    public static void main(String[] args) {
        String input = "Hello WorlD";

        // Count uppercase letter in string using stream
        long upperCaseCount = input.chars()
                .filter(Character::isUpperCase)
                .count();
        System.out.println("UpperCase count is "+upperCaseCount);

        // Filter all string with length greater than 5
        List<String> stringList = Arrays.asList("This","is","JAVA","problem");
        stringList = stringList.stream().filter(s -> s.length()>5).collect(Collectors.toList());
        System.out.println("Filtered list "+stringList);

        // Is List Contains palindrome
        stringList = Arrays.asList("madam","taught","Java");
        Predicate<String> checkPalindrome = a -> a.equals(new StringBuilder(a).reverse().toString());
        boolean isContainPalindrome = stringList.stream().anyMatch(checkPalindrome);
        System.out.println("List contains palindrome "+isContainPalindrome);

        // Concat List of String to make single string
        List<String> words = Arrays.asList("My","Name","Is","Java");
        String concatedString = words.stream().collect(Collectors.joining());
        String concatUsingReduce = words.stream().reduce("", (str1, str2) -> str1 + str2);
        System.out.println("concatedString "+concatedString+" "+concatUsingReduce);
        String delimiter = "-";
        String joinStrUsingDelimiter = words.stream().collect(Collectors.joining(delimiter));
        System.out.println("Joined String using delimiter "+joinStrUsingDelimiter);

        // Character count of String
        String strWithDuplicates = "aabbccddeeFFGGHHiiJJkkLLmmnnooPQQrrssttuuvvWWXXYYz";
        Map<Character, Long> charCount = strWithDuplicates.chars().mapToObj(a-> (char) a).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // find the longest string in list

    }
}
