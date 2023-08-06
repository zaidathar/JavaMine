package com.zaidathar.problems.basic;

import java.util.Arrays;

public class MethodOverloading {
    /*

       What if there is two overloaded method and pass value as null

       Case 1:
        When there is only one method with parameter as object.
        Then "Call me with object" will be printed.

       Case 2:
        When there is one more method with parameter as String.
        Then "Call me with String" will be printed because child class will got
        priority over parent as String is child of Object.

       Case 3:
        When there is one more method with parameter as Integer ( Now 3 overloaded method).
        Then we get compile time error , because JVM will found 2 overloaded method parameter
        can be null and both are child of Object class then there is ambiguity. As overloading
        always done at compile time.


     */

    public static void main(String[] args) {
        Pair
        callMe(null);

    }

    public static void callMe(Object object){
        System.out.println("Call me with object");
    }
    public static void callMe(String str){
        System.out.println("Call me with String");
    }

    public static void callMe(Integer num){
        System.out.println("Call me with Integer");
    }
}
