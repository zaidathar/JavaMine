package com.zaidathar.concept.other.comparable_comparator;

import com.zaidathar.helpers.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorImpl {
    public static void main(String[] args) {
        List<Employee> l = Arrays.asList(
                new Employee(3,"zaid3","Java",24530.0d,"avnsd","aaa"),
                new Employee(1,"zaid1","Java",23459.0d,"avnsd","aaa"),
                new Employee(4,"zaid4","Java",39439.0d,"avnsd","aaa"),
                new Employee(2,"zaid2","Java",22222.0d,"avnsd","aaa")
        );
        EmployeeSalaryComparator employeeSalaryComparator = new EmployeeSalaryComparator();
        Collections.sort(l, employeeSalaryComparator);

        for(Employee employee : l){
            System.out.println(employee.getId()+" "+employee.getName()+" "+employee.getSalary());
        }
    }
}
