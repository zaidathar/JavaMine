package com.zaidathar.concept.java8.functional_interface;

@FunctionalInterface
public interface MyFunction<T, U> {
    U compute(T t);
}
