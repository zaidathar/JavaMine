package com.zaidathar.problems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnagramProblems {
    public static void printAnagramTogether(List<String> names){
        // consider all names are in lower case and alphabets only

        Map<String, List<String>> groups = names.stream()
                .collect(
                        Collectors.groupingBy(
                                name ->{
                                    char[] arr = name.toCharArray();
                                    Arrays.sort(arr);

                                    return new String(arr);
                                }
                        )
                );

        groups.entrySet().stream().forEach(entry ->{
            entry.getValue().stream().forEach(name -> System.out.print(name+" "));
            System.out.println();
        });

    }
    public static void main(String[] args) {
        List<String> names = Arrays.asList("java","avaj","abcd","dcba","zaid");
        printAnagramTogether(names);
    }
}
