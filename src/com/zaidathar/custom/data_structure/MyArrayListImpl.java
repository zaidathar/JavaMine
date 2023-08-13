package com.zaidathar.custom.data_structure;

public class MyArrayListImpl {
    public static void main(String[] args) throws Exception {

        // String type
        MyArrayList<String> stringList = new MyArrayList<>();
        stringList.insert("Zaid");
        stringList.insert("Loves");
        stringList.insert("Java");
        System.out.println("Length of list "+ stringList.size());
        stringList.print();
        stringList.remove("Java");
        stringList.insert("All");
        // After this resizing of list will be done as 75% size is filled.
        stringList.insert("Programming");
        stringList.insert("Languages");
        stringList.insert("Exists");
        stringList.insert("!!");
        System.out.println("Length of list "+ stringList.size());
        stringList.print();

        /**
         * Integer List with variable type as raw.
         * MyArrayList<Integer>() used to specify type of the constructor parameter.
         * JVM will not give type safety error.
         * This is not good practice as raw type is not checked on compile time and our class is generic.
           In this case we are able to add String in our Integer List.
         * MyArrayList<Integer> integerList used to declare type of variable , always specify type of variable.
         */

        MyArrayList integerList = new MyArrayList<Integer>(3);

        integerList.insert(1);
        integerList.insert(2);
        integerList.insert(3);
        integerList.insert("This is String in Integer ArrayList");
        integerList.print();


        System.out.println("Length of list "+ integerList.size());



    }
}
