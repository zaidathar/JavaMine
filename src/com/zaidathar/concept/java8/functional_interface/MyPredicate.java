package com.zaidathar.concept.java8.functional_interface;

@FunctionalInterface
public interface MyPredicate<T> {
    boolean test(T t);
}
