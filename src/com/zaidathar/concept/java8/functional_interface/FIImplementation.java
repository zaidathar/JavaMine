package com.zaidathar.concept.java8.functional_interface;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FIImplementation {
    public static void main(String[] args) {
        // Consumer is functional interface which takes 1 value and return nothing
        // Java Consumer
        Consumer<Integer> c = a -> System.out.println("Value is : "+a);
        c.accept(89);

        // Custom Consumer functional interface
        MyConsumer<String> consumer = val -> System.out.println("Selected value is : "+val);
        consumer.myPrint("Java");


        // Predicate is functional interface which takes 1 value and return boolean
        // Java Predicate
        Predicate<String> p = str -> str.equalsIgnoreCase("java");
        p.test("JaVa");

        // Custom Predicate FI
        MyPredicate<Double> predicateDouble = d -> d == 10.2d;
        predicateDouble.test(10.3d);



    }
}
