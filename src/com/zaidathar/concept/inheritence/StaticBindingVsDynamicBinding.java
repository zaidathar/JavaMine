package com.zaidathar.concept.inheritence;

class Parent {
    static void staticMethod() {
        System.out.println("Static method of Parent");
    }

    void dynamicMethod() {
        System.out.println("Dynamic method of Parent");
    }
}

class Child extends Parent {
    static void staticMethod() {
        System.out.println("Static method of Child");
    }

    void dynamicMethod() {
        System.out.println("Dynamic method of Child");
    }
}

public class StaticBindingVsDynamicBinding {
    public static void main(String[] args) {
        Parent obj1 = new Child();
        Child obj2 = new Child();

        /*
        * This call staticMethod() from class Parent
        * Because static methods are resolved at compiled time based on reference type
        * As obj1 is reference of Parent
        * */
        obj1.staticMethod();

        /*
        * This will call dynamicMethod() from Class Child
        * Because dynamic methods are resolved at runtime based on actual object type
        * As obj1 is object of Child
        * */
        obj1.dynamicMethod();

        /*
        * This will call staticMethod() and dynamicMethod() from class Child
        * Because reference type and actual object both are of Child class.
        * */

        obj2.staticMethod();
        obj2.dynamicMethod();
    }
}
