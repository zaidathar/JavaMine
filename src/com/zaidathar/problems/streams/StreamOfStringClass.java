package com.zaidathar.problems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    }
}
