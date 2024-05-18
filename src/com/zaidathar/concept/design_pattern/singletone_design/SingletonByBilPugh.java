package com.zaidathar.concept.design_pattern.singletone_design;

public class SingletonByBilPugh {
    private SingletonByBilPugh(){}

    private static class SingletonInstantiation{
        private static final SingletonByBilPugh instance = new SingletonByBilPugh();
    }

    public static SingletonByBilPugh getInstance(){
        return SingletonInstantiation.instance;
    }
}
