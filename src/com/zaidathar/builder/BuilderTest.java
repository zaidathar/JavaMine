package com.zaidathar.builder;

public class BuilderTest {
    public static void main(String[] args) {
        MyClassWithBuilder builder = MyClassWithBuilder.builder()
                                        .name("Java")
                                        .address("Internet")
                                        .age(25)
                                        .build();
        System.out.println(builder);
    }
}
