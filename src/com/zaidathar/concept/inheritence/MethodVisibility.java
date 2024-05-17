package com.zaidathar.concept.inheritence;

class A {
    void methodA() {
        System.out.println("Parent");
    }
}

class B extends A {
    void methodB() {
        System.out.println("B");
    }
}

class C extends B {
    void methodC() {
        System.out.println("C");
    }
}


public class MethodVisibility {
    public static void main(String[] args) {
        A obj = new C();
        obj.methodA();

        /*
        * As obj is instance of Class C but holding reference of Class Parent
        * methodB() and methodC() is not defined in Class Parent
        * That is why methodA() is only visible to obj object.
        * This will give your `compilation error` when you call methodB() and methodC()
        * */

        // obj.methodB();
        // obj.methodC();
    }
}
