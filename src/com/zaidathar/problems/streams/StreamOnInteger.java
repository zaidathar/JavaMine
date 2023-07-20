package com.zaidathar.problems.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOnInteger {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        // Find sum of even numbers in list
        int evenSumByReduce = list.stream().filter(n -> n%2 ==0).reduce(0, (a,b) -> a+b);
        int evenSumByMapToInt = list.stream().filter(n -> n%2 == 0).mapToInt(Integer::intValue).sum();
        int evenSumBySummingInt = list.stream().filter(n -> n%2 ==0).collect(Collectors.summingInt(Integer::intValue));
        int evenSumByReducing = list.stream().filter(n->n%2==0).collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Even sum by reduce "+evenSumByReduce);
        System.out.println("Even sum by MapToInt "+evenSumByMapToInt);
        System.out.println("Even sum by summingInt "+evenSumBySummingInt);
        System.out.println("Even sum by reducing "+evenSumByReducing);

        // Find the average of numbers
        List<Integer> salaries = Arrays.asList(1002,1021,1989,1342,4532);
        double averageSalary = salaries.stream()
                               .mapToInt(Integer::intValue)
                               .average()
                               .getAsDouble();
        double avgSalUsingAveraging = salaries.stream()
                                          .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("average salary "+averageSalary+" "+avgSalUsingAveraging);

    }
}
