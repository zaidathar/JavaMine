package com.zaidathar.concept.java8.default_method;

public interface Interface1 {
    int age = 10;
    void calculate(int a, int b);

    default void printName(String s){
        System.out.println("Name in Interface1 is "+s);
    }

    static void printMyAge(){
        System.out.println("My age is "+age);
    }

    /**
     * default method can't override toString method of object class it will give compile-error

    default void toString(){

    }

     */
}
