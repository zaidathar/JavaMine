package com.zaidathar.problems.streams;

import com.zaidathar.helpers.Employee;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamProblems {
    public static void checkDuplicate(){
        List<String> names = Arrays.asList("java","stream","problem","for","java","stream");
        // using frequency filter duplicate values
        Set<String> duplicateValues = names.stream()
                .filter(i -> Collections.frequency(names,i) > 1)
                .collect(Collectors.toSet());
        System.out.println("Duplicate values "+duplicateValues);

        // using set
        Set<String> set = new HashSet<>();

        boolean isDuplicate = names.stream().anyMatch(a -> !set.add(a));
        System.out.println("is Duplicate found : "+isDuplicate);
        Set<String> set2 = new HashSet<>();
        List<String> duplicateName = names.stream()
                .filter(i -> !set2.add(i))
                .collect(Collectors.toList());
        System.out.println("Duplicates name "+duplicateName);


        /* Check Duplicate in Character Array */

        List<Character> charList = Arrays.asList('C','A','B','C','A','D');

        // Using freqency
        Set<Character> duplicateChar = charList.stream()
                .filter(i -> Collections.frequency(charList, i) > 1)
                .collect(Collectors.toSet());

        // using grouping by
        Set<Character> dupChar = charList.stream()
                .collect(
                        Collectors.groupingBy(
                                Function.identity(),
                                Collectors.counting()
                        )
                )
                .entrySet()
                .stream()
                .filter( i -> i.getValue() > 1)
                .map( a -> a.getKey())
                .collect(Collectors.toSet());
        System.out.println("Duplicate Value using grouping By : "+dupChar);

    }

    public static void charCountInString(){
        String s = new String("Mississippi");
        char c = 's';

        long count = s.chars()
                .filter( i -> i == c)
                .count();

    }
    public static void main(String[] args) {
        checkDuplicate();

        List<String> intStringList = Arrays.asList("1","2","3","4","5","6","7");

        List<Integer> integerList = intStringList.stream().map(Integer::parseInt).collect(Collectors.toList());
        int sum = integerList.stream().mapToInt(Integer::intValue).sum();
        Long sumByStat = intStringList.stream().map(Integer::parseInt).mapToInt(Integer::intValue).summaryStatistics().getSum();

        String lastElement = intStringList.stream()
                .reduce((first, second) -> second)
                .orElse(null);

        String lastUsingSkip = intStringList.stream()
                .skip(intStringList.size()-1)
                .findFirst()
                .orElse(null);

        String lastUsingSort = intStringList.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);

        List<Employee> employees = Arrays.asList(
                new Employee("John","Java",1239021.00,"919292992", "acnd@gmail.com"),
                new Employee("Jony","Java",1129021.00,"919292992", "acnd@gmail.com"),
                new Employee("Janardhan","HR",1003921.00,"919292992", "acnd@gmail.com"),
                new Employee("Hamid","HR",1239021.00,"919292992", "acnd@gmail.com"),
                new Employee("Nizam","Python",1439021.00,"919292992", "acnd@gmail.com"),
                new Employee("Ahmad","Python",100021.00,"919292992", "acnd@gmail.com")

        );

        employees.stream()
                .collect(
                        Collectors.groupingBy(
                               Employee::getDepartment,
                                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)),
                                Optional::get)
                        )
                )
                .entrySet()
                .stream()
                .forEach(e -> System.out.println(e.getKey()+" "+e.getValue().getSalary()));
    }
}
