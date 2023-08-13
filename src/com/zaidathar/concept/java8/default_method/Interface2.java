package com.zaidathar.concept.java8.default_method;

public interface Interface2 {
    int age = 10;
    void calculate(int a, int b);

    /**
     * If you add same default method as Interface1
     * Class must override default method if it implement Interface1 and Interface2 both.
     */
    default void printName(String s){
        System.out.println("Name in Interface2 is "+s);
    }

    static void printMyAge(){
        System.out.println("My age is "+age);
    }
}
