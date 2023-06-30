package com.zaidathar.concept.design_pattern.singletone_design;

public class SingletonClass{
    // This is doubly check singleton class 
    private static volatile SingletonClass _instance;

    private SingletonClass(){
    }

    public static SingletonClass getInstance(){
        //Dual lock check for thread safety 
        if( _instance == null){
            synchronized(SingletonDemo.class){
                if(_instance == null){
                    _instance = new SingletonClass();
                }
            }
        }   
        return _instance;
    }

    
}
