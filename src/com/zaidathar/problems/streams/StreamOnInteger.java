package com.zaidathar.problems.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        // Change number to Square Root
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Double> squareRoots = numbers.stream().map(Math::sqrt).collect(Collectors.toList());
        squareRoots.stream().forEach(System.out::println);

        // Remove Duplicate from List
        List<Integer> duplicateNumbers = Arrays.asList(1,2,3,4,5,1,2,0,6,7,8);
        List<Integer> uniqueNumbers = duplicateNumbers.stream()
                                        .distinct()
                                        .collect(Collectors.toList());

        System.out.println(uniqueNumbers);

        // Sum of square of numbers
        int sumOfSquare = numbers.stream().mapToInt(n -> n*n).sum();
        System.out.println("Sum of squares of number "+sumOfSquare);

        // Max and minimum in list
        Integer min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
        Integer max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
        System.out.println("Min is "+min+" max is "+max);

        // Max and mininum in Array
        int[] intArray = {1,5,6,2,3,8,9,11,99,4};
        int minInArray = Arrays.stream(intArray).mapToObj(Integer::valueOf).min(Integer::compareTo).get();
        int maxInArray = Arrays.stream(intArray).mapToObj(Integer::valueOf).max(Integer::compareTo).get();
        System.out.println("In Array -> Min: "+minInArray+" Max : "+maxInArray);

        // Max and min using Summary Statics
        IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        min = stats.getMin();
        max = stats.getMax();
        System.out.println("Min is "+min+" max is "+max);

        // Partition list into two list containing even and odd number

        Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(n -> n%2==0));
        List<Integer> evenList = partition.get(true);
        List<Integer> oddList = partition.get(false);

        System.out.println("List with even "+evenList);
        System.out.println("List with odd "+oddList);

        // Factorial of numbers
        List<Integer> toBeFactorial = Arrays.asList(1,2,3,4,5,6,8);
        Function<Integer, Integer> factorial = (a) -> IntStream.rangeClosed(2,a).reduce(1, (x,y) -> x*y);
        List<Integer> factorialList = toBeFactorial.stream().map( factorial).collect(Collectors.toList());
        System.out.println("Factorial List "+factorialList);
    }
}
