package com.zaidathar.builder;

public class MyGenericClass <T , G>{
    private T field;
    private G value;

    MyGenericClass(GenericBuilder gb){
        this.field = (T)gb.field;
        this.value = (G)gb.value;
    }

    public static GenericBuilder builder(){
        return new GenericBuilder();
    }

    public T getField() {
        return field;
    }

    public G getValue() {
        return value;
    }

    public static class GenericBuilder<T, G>{
        private T field;
        private G value;

        public GenericBuilder(){

        }

        public GenericBuilder field(T field){
            this.field = field;
            return this;
        }

        public GenericBuilder value(G value){
            this.value = value;
            return this;
        }

        public MyGenericClass build(){
            return new MyGenericClass(this);
        }
    }

    @Override
    public String toString(){
        return "Field : "+this.field+" \n"+
                "Value : "+this.value;
    }
}
