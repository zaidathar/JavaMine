package com.zaidathar.problems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> lists = Arrays.asList(
                Arrays.asList("Hi","there !"),
                Arrays.asList("this","is","Java"),
                Arrays.asList("an","awesome","language")
        );

        List<String> singleList = lists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
