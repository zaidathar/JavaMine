package com.zaidathar.problems.streams;

import com.zaidathar.helpers.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ListToString {
    public static String getEmployeesNames(List<Employee> ls){
        return ls.stream().map(Employee::getName).collect(Collectors.joining(", "));
    }
    public static void main(String[] args) {
        List<Employee> ls = Arrays.asList(
                new Employee("Alex", "Java Web", 124000.0, "+12344", "random@random.java"),
                new Employee("Max", "Java Web", 124000.0, "+12344", "random@random.java"),
                new Employee("Smith", "Java Web", 124000.0, "+12344", "random@random.java"),
                new Employee("Joe", "Java Web", 124000.0, "+12344", "random@random.java"),
                new Employee("Hashim", "Java Web", 124000.0, "+12344", "random@random.java")
        );

        System.out.println("Employee names : "+getEmployeesNames(ls));
    }
}
