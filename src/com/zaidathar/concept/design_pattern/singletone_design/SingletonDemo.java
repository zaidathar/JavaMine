package com.zaidathar.concept.design_pattern.singletone_design;

public class SingletonDemo implements Runnable {
    @Override
    public void run()
    {
        System.out.println("Inside run method for "+Thread.currentThread().getName());
        try{
            SingletonClass singletonClass = SingletonClass.getInstance();
            System.out.println(singletonClass.hashCode());
        }
        catch(Exception e){
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        Thread t1 = new Thread(new SingletonDemo(),"t1");
        
        Thread t2 = new Thread(new SingletonDemo(), "t2");
        t1.start();
        t2.start();

    }
}
