package com.zaidathar.helpers;

public class Employee implements Comparable<Employee>{
    private Integer id;
    private String name;
    private String department;
    private Double salary;
    private String contact;
    private String email;
    private Integer age;

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
    public Employee(Integer id, String name, String department, Double salary, String contact, String email,Integer age) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.contact = contact;
        this.email = email;
        this.age = age;
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

    public Integer getAge(){
        return this.age;
    }

    public void setAge(Integer age){
        this.age = age;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Employee))
            return false;
        return ((Employee)obj).id == this.id;
    }

    @Override
    public int hashCode() {
        return this.id+this.name.length()+(22*id);
    }

    @Override
    public int compareTo(Employee o) {
        return this.id - o.id;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", age='"+age+'\''+
                '}';
    }
}
