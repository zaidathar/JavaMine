package com.zaidathar.problems.streams;

import com.zaidathar.helpers.Employee;

import java.util.*;
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
    * Find employee which have the highest salary
    * */

    public static Employee findEmployeeWithHighestSalary(List<Employee> employees){
        return employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst().get();
    }

    public static Map<String , Optional<Employee>> findMaxSalaryInEachDepartment(List<Employee> employees){
        return employees.stream().collect(
                Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)
                )
            )
        );
    }


    public static Map<Integer, Set<String>> groupEmployeeByAge(List<Employee> employees){
        return employees.stream()
                .collect(
                        Collectors.groupingBy(
                            Employee::getAge,
                            Collectors.mapping(
                                    Employee::getName,
                                    Collectors.toSet()
                            )
                        )
                );
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1,"Joe","Sales",54900d,"91991919","email@email.com",32),
                new Employee(2,"Smith","Sales",34920d,"91991919","email@email.com",32),
                new Employee(3,"Anas","Java",69060d,"91991919","email@email.com",43),
                new Employee(4,"Musa","Java",59060d,"91991919","email@email.com",43)
        );

        List<Employee> filteredEmployees = filterEmployeeBySalaryAndDepartment(employees,51000d,"Sales");
        filteredEmployees.stream().forEach(e -> System.out.println(e.getName()));
        findEmployeesName(employees).stream().forEach(System.out::println);
        System.out.println("Highest salary employee : "+findEmployeeWithHighestSalary(employees));

        findMaxSalaryInEachDepartment(employees)
                .entrySet()
                .forEach(e -> System.out.println(e.getKey()+" -> "+e.getValue().get().getSalary()));

        System.out.println("Grouping employee by age");
        groupEmployeeByAge(employees)
                .entrySet()
                .forEach(e -> System.out.println(e.getKey()+ " "+e.getValue()));
    }
}
