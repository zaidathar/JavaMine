package com.zaidathar.concept.inheritence;

class Top{
    static {
        System.out.println("Static block of Top");
    }

    {
        System.out.println("Instance block of Top");
    }

    Top() {
        System.out.println("Constructor of Top");
    }
}

class Bottom extends Top{
    static {
        System.out.println("Static block of Bottom");
    }

    {
        System.out.println("Instance block of Bottom");
    }

    Bottom() {
        System.out.println("Constructor of Bottom");
    }
}

public class StaticVsInstanceInitialization {
    public static void main(String[] args) {
        Bottom obj = new Bottom();
        Bottom b = new Bottom();
        /*
        * Static blocks are executed when the class is loaded into memory,
        * They execute only once per class.
        * Static blocks are executed in the order the classes are loaded, regardless of the object creation sequence.

        * Note: If you comment Bottom obj = new Bottom(); , it will print nothing
        *      - Because no class loaded into memory
        *      - To print static block in this case extend Bottom into StaticVsInstanceInitialization
        * */

        /*
        * Instance blocks and constructors are executed when an object of the class is created.

        * */
    }
}
