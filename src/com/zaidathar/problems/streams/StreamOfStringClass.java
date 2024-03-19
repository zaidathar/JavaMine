package com.zaidathar.problems.streams;

import java.util.*;
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

        String upperCase = input.chars()
                .mapToObj(c->(char)c)
                .map(Character::toUpperCase)
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();


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

        // Find the duplicate Strings in list using Set
        List<String> arr = Arrays.asList("Java","Python", "Java", "C" , "Php", "C","C","JS");
        Set<String> set = new HashSet<>();
        List<String> duplicates = arr.stream()
                .filter(s -> !set.add(s))
                .distinct() // take distinct after first insertion set give false for same string
                .collect(Collectors.toList());
        System.out.println(duplicates);

        // Find the duplicate Strings in list using group by
        List<String> duplicateStr = arr.stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        System.out.println(duplicateStr);

    }
}
