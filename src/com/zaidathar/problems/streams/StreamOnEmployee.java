package com.zaidathar.problems.streams;

import com.zaidathar.helpers.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamOnEmployee {

    /*
    * We have to find list of employees of particular department whose salary is
      greater than or equal to given salary.
    * */
    public static List<Employee> filterEmployeeBySalaryAndDepartment(List<Employee> employees,
                                                                     double salary, String department){
        return employees.stream()
                .filter(e -> e.getSalary() >= salary && e.getDepartment().equalsIgnoreCase(department))
                .collect(Collectors.toList());
    }

    public static List<String> findEmployeesName(List<Employee> employees){
        return employees.stream()
                .map(e -> e.getName())
                .collect(Collectors.toList());
    }

    /*
    * Find employee which have highest salary
    * */

    public static Employee findEmployeeWithHighestSalary(List<Employee> employees){
        return null;
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Joe","Sales",54900d,"91991919","email@email.com"),
                new Employee("Smith","Sales",34920d,"91991919","email@email.com"),
                new Employee("Anas","Java",69060d,"91991919","email@email.com"),
                new Employee("Musa","Java",59060d,"91991919","email@email.com")
        );

        List<Employee> filteredEmployees = filterEmployeeBySalaryAndDepartment(employees,51000d,"Sales");
        filteredEmployees.stream().forEach(e -> System.out.println(e.getName()));
        findEmployeesName(employees).stream().forEach(System.out::println);
    }
}
