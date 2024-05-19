package com.zaidathar.problems.streams;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOnInteger {
    public static void main(String[] args) {


        findSumOfEvenByReduce();
        findSumOfEvenBySumMethod();
        findSumOfEvenUsingSummingInt();
        findSumOfEvenByReducing();

        findAverageSalary();
        findAverageSalaryUsingAveraging();

        calculateSquareRoot();

        removeDuplicateFromList();

        sumOfSquareOfNumbers();

        minMaxInList();
        minMaxInArray();
        minMaxBySummaryStatics();

        partitioningEvenOdd();
        generateFactorialOfNumbers();
        generateFibonacciSequence();
        findMedianOfList();
        primeNumberGrouping();
        curryTechnique();
    }

    private static void findSumOfEvenByReduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int evenSumByReduce = list
                .stream()
                .filter(n -> n%2 ==0)
                .reduce(0, (a,b) -> a+b);
        System.out.println("Even sum by reduce "+evenSumByReduce);
    }

    private static void findSumOfEvenBySumMethod(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int evenSumBySumMethod = list.stream().filter(n -> n%2 == 0).mapToInt(Integer::intValue).sum();
        System.out.println("Even sum by Sum method "+evenSumBySumMethod);
    }

    private static void findSumOfEvenUsingSummingInt(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int evenSumBySummingInt = list
                .stream()
                .filter(n -> n%2 ==0)
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println("Even sum by summingInt "+evenSumBySummingInt);

    }

    private static void findSumOfEvenByReducing(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        int evenSumByReducing = list
                .stream()
                .filter(n->n%2==0)
                .collect(Collectors.reducing(0, Integer::sum));
        System.out.println("Even sum by reducing "+evenSumByReducing);
    }

    private static void findAverageSalary(){
        List<Integer> salaries = Arrays.asList(1002,1021,1989,1342,4532);
        double averageSalary = salaries.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
        System.out.println("average salary "+averageSalary);

    }

    private static void findAverageSalaryUsingAveraging(){
        List<Integer> salaries = Arrays.asList(1002,1021,1989,1342,4532);

        double avgSalUsingAveraging = salaries.stream()
                .collect(Collectors.averagingInt(Integer::intValue));

        System.out.println("average salary using averaging "+avgSalUsingAveraging);
    }

    private static void calculateSquareRoot(){
        // Change number to Square Root
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        List<Double> squareRoots = numbers.stream().map(Math::sqrt).collect(Collectors.toList());
        System.out.println("Square root of numbers ");
        squareRoots.stream().forEach(n -> System.out.print(n+" "));
        System.out.println();
    }

    private static void removeDuplicateFromList(){
        // Remove Duplicate from List
        List<Integer> duplicateNumbers = Arrays.asList(1,2,3,4,5,1,2,0,6,7,8);
        List<Integer> uniqueNumbers = duplicateNumbers.stream()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(uniqueNumbers);
    }

    private static void sumOfSquareOfNumbers(){
        // Sum of square of numbers
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        int sumOfSquare = numbers.stream().mapToInt(n -> n*n).sum();
        System.out.println("Sum of squares of number "+sumOfSquare);
    }

    private static void minMaxInList(){
        // Max and minimum in list
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        Integer min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
        Integer max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();
        System.out.println("Min is "+min+" max is "+max);
    }

    private static void minMaxInArray(){
        // Max and minimum in Array
        int[] intArray = {1,5,6,2,3,8,9,11,99,4};
        int minInArray = Arrays.stream(intArray).mapToObj(Integer::valueOf).min(Integer::compareTo).get();
        int maxInArray = Arrays.stream(intArray).mapToObj(Integer::valueOf).max(Integer::compareTo).get();
        System.out.println("In Array -> Min: "+minInArray+" Max : "+maxInArray);
    }

    private static void minMaxBySummaryStatics(){
        // Max and min using Summary Statics
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
        IntSummaryStatistics stats = numbers.stream().mapToInt(Integer::intValue).summaryStatistics();
        int min = stats.getMin();
        int max = stats.getMax();
        System.out.println("Min is "+min+" max is "+max);
    }

    private static void partitioningEvenOdd(){
        // Partition list into two list containing even and odd number

        Map<Boolean, List<Integer>> partition = numbers.stream().collect(Collectors.partitioningBy(n -> n%2==0));
        List<Integer> evenList = partition.get(true);
        List<Integer> oddList = partition.get(false);

        System.out.println("List with even "+evenList);
        System.out.println("List with odd "+oddList);
    }

    private static void generateFactorialOfNumbers(){
        // Factorial of numbers
        List<Integer> toBeFactorial = Arrays.asList(1,2,3,4,5,6,8);
        Function<Integer, Integer> factorial = (a) -> IntStream.rangeClosed(2,a).reduce(1, (x,y) -> x*y);
        List<Integer> factorialList = toBeFactorial.stream().map( factorial).collect(Collectors.toList());
        System.out.println("Factorial List "+factorialList);
    }

    private static void generateFibonacciSequence(){
        // Generate Fibonacci sequence

        /*
            - using iterate(seed , f(seed)), f(seed) perform operation on previous value
            - each time new array will be created {0,1} , {1,1},{1,2},{2,3},{3,5}
            - first index value will be fibonacci sequence
            - should put limit because iterate gives infinite sequential order stream
         */
        int N = 10;
        List<Integer> fibonacciSequence = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(N)
                .map(t -> t[0])
                .collect(Collectors.toList());
        System.out.println("Fibonacci list "+fibonacciSequence);
    }


    private static void findMedianOfList(){
        // Find the median of integer list

        List<Integer> numberList = Arrays.asList(1, 3, 5, 7, 9, 11, 13,15);

        double median = numberList.stream()
                .sorted()
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        listOfNumber ->{
                            int size = listOfNumber.size();

                            if(size % 2 ==0 ){
                                return (listOfNumber.get((size/2) -1) + listOfNumber.get(size/2))/2.0;
                            }
                            else{
                                return (double)listOfNumber.get(size/2);
                            }
                        }
                ));


        System.out.println("Median of list : "+median);

    }

    private static void primeNumberGrouping(){
        Predicate<Integer> isPrime = number ->{
            return ( number > 1 &&
                    IntStream.rangeClosed(2,(int) Math.sqrt(number))
                            .noneMatch(a -> number % a ==0)
                    );
        };


        List<Integer> numbers = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> primeNumGrouping = numbers
                .stream()
                .collect(Collectors.partitioningBy(
                        isPrime,
                        Collectors.toList()
                ));

        System.out.println("Prime numbers : "+primeNumGrouping.get(true));
        System.out.println("Non Prime numbers : "+primeNumGrouping.get(false));

    }

    private static void curryTechnique(){
        // Currying Technique

        Function<Double, Function<Double, Double>> weight = gravity -> mass -> mass * gravity;

        Function<Double, Double> weightOnEarth = weight.apply(9.81);
        System.out.println( "My weight on Earth: " + weightOnEarth.apply(60.0));

        Function<Double, Double> weightOnMars = weight.apply(3.75);
        System.out.println( "My weight on Mars: " + weightOnMars.apply(60.0));
    }
}
