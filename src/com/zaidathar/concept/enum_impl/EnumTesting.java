package com.zaidathar.concept.enum_impl;

public class EnumTesting {

    public static void main(String[] args) {
        MyEnum one = MyEnum.ONE;
        MyEnum two = MyEnum.TWO;

        System.out.println(one.toString());
        System.out.println(one.name());
        System.out.println(one.ordinal());
        System.out.println(two.toString());
        System.out.println(two.name());
        System.out.println(two.ordinal());
        System.out.println(two.getDeclaringClass());

        String url = "GET-api/v1/get-costumer";
        String urlDescription = UrlDescription.getDescription("");

        System.out.println("URL -> "+url +" : "+urlDescription);
    }
}
