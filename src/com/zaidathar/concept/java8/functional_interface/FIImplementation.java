package com.zaidathar.concept.java8.functional_interface;

import com.zaidathar.utils.StringUtils;

import java.util.function.*;

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

        // Function is functional interface which takes 1 value and return value after processing return value
        // Java Function
        Function<Integer, Integer> square = a -> a*a;
        Integer result = square.apply(3);
        System.out.println("Square of 3 = "+result);
        // BiFunction
        BiFunction<Integer,Double, Integer> intMultiplyDouble = (a , b) -> a * b.intValue();
        System.out.println("Int multiply double res = "+intMultiplyDouble.apply(2 , 2.2d));
        //Custom Function
        MyFunction<String , Integer> strToTripleInt = str -> 3*Integer.valueOf(str);
        System.out.println("Triple of string '4' = " +strToTripleInt.compute("4"));

        // Supplier is functional interface which doesn't take any value yet return a single value
        // Java Supplier
        Supplier<Double> supplier = () -> Math.random();
        System.out.println("Random number by supplier = "+ supplier.get());

        //Custom supplier
        MySupplier<String> stringSupplier = () -> StringUtils.generateRandomString(20);

        System.out.println("Random string by supplier = "+stringSupplier.supply());



    }
}
