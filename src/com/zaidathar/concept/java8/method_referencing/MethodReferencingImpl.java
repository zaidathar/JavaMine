package com.zaidathar.concept.java8.method_referencing;

import com.zaidathar.helpers.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferencingImpl {

    public static int compareByName(Employee e1 , Employee e2){
        return e1.getName().compareTo(e2.getName());
    }

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(3,"zaid","Java",24530.0d,"avnsd","aaa"),
                new Employee(1,"athar","Java",23459.0d,"avnsd","aaa"),
                new Employee(4,"java","Java",39439.0d,"avnsd","aaa"),
                new Employee(2,"programming","Java",22222.0d,"avnsd","aaa")
        );

        List<Employee> cloneEmp = employees.stream().collect(Collectors.toList());
        List<String> names = employees.stream().map( e -> e.getName()).collect(Collectors.toList());

        // Static Method referencing
        Collections.sort(employees, MethodReferencingImpl::compareByName);

        for(Employee e : employees){
            System.out.println(e);
        }

        // Instance method referencing of particular object
        Comparison comparators = new Comparison();
        Collections.sort(cloneEmp, comparators::compareBySalary);

        // Instance method referencing of arbitrary object of particular type
        Collections.sort(names, String::compareToIgnoreCase);


    }
}

class Comparison{
    public int compareByName(Employee e1 , Employee e2){
        return e1.getName().compareTo(e2.getName());
    }

    public int compareBySalary(Employee e1 , Employee e2){
        return e1.getSalary().compareTo(e2.getSalary());
    }
}