package com.zaidathar.builder;

public class MyClassWithBuilder {
    private String name;
    private int age;
    private String address;

    public MyClassWithBuilder(CustomBuilder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.age = builder.age;
    }

    public static CustomBuilder builder(){
        return new CustomBuilder();
    }

    @Override
    public String toString(){
        return "Name : "+this.name+"\n"+
                "Age : "+this.age+"\n"+
                "Address: "+this.address+"\n";
    }

    public static class CustomBuilder{
        private String name;
        private int age;
        private String address;

        public CustomBuilder(){}
        public CustomBuilder(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;;
        }

        public CustomBuilder name(String name){
            this.name = name;
            return this;
        }

        public CustomBuilder age(int age){
            this.age = age;
            return this;
        }

        public CustomBuilder address(String address){
            this.address = address;
            return this;
        }

        public MyClassWithBuilder build(){
            return new MyClassWithBuilder(this);
        }

    }
}