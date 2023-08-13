package com.zaidathar.concept.java8.default_method;

public class DefaultMethodImpl implements Interface1,Interface2{
    @Override
    public void calculate(int a, int b) {

    }

    /**
     * If both interface have same default method.
     * You must be overriding default method and call Interface default method from there.
     */
    @Override
    public void printName(String s) {
        Interface1.super.printName(s);
        Interface2.super.printName(s);
    }

    public static void main(String[] args) {
        DefaultMethodImpl obj =  new DefaultMethodImpl();
        obj.printName("Zaid");
    }
}
