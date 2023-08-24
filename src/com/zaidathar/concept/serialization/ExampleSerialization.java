package com.zaidathar.concept.serialization;

import java.io.Serializable;

public class ExampleSerialization extends ParentClass implements Serializable {
    public static final long serialVersionUID = 12846927472071L;

    private String name;
    private String address ;
    private int age;
    private transient String phone;
    private static Integer num = 19820;

    public ExampleSerialization(){
        System.out.println("Hi No Param constructor");

    }

    public ExampleSerialization(String name, String address, int age, String phone){
        this.name = name;
        this.address = address;
        this.age = age;
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Employee detail [ 'name' : "+this.name+
                ", 'address' : "+this.address+
                ", 'age' : "+this.age+
                ", 'phone' :"+this.phone+" ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Integer getNum() {
        return num;
    }

    public static void setNum(Integer num) {
        ExampleSerialization.num = num;
    }
}
