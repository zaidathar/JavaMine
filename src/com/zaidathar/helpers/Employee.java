package com.zaidathar.helpers;

public class Employee implements Comparable<Employee>{
    private Integer id;
    private String name;
    private String department;
    private Double salary;
    private String contact;
    private String email;

    public Employee(){

    }

    public Employee(String name, String department, Double salary, String contact, String email) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.contact = contact;
        this.email = email;
    }

    public Employee(Integer id, String name, String department, Double salary, String contact, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.contact = contact;
        this.email = email;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;

    }
}
