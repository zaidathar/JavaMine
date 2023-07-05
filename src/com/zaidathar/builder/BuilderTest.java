package com.zaidathar.builder;

public class BuilderTest {
    public static void main(String[] args) {
        MyClassWithBuilder builder = MyClassWithBuilder.builder()
                                        .name("Java")
                                        .address("Internet")
                                        .age(25)
                                        .build();

        MyGenericClass<String, Integer> genericStringAndInt = MyGenericClass.builder()
                                                        .field("Score")
                                                        .value(89)
                                                        .build();

        /*
            Another way to initialize generic class using raw type
            Create object by providing type for builder

        * */
        MyGenericClass genericIntAndDouble = MyGenericClass.<Integer, Double> builder()
                                                                .field(10)
                                                                .value(10.0d)
                                                                .build();

        System.out.println(builder);
        System.out.println(genericStringAndInt);
        System.out.println(genericIntAndDouble);
    }
}
