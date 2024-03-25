package com.zaidathar.concept.multithreading.deadlock;

public class SharedResource {
    private int value = 10;

    public synchronized void printValue(){

        System.out.println("Lock acquired by "+Thread.currentThread().getName());
        System.out.println("Value = "+value);
        try{
            Thread.sleep(10000);
        }
        catch (Exception e){
            //Exception handling
        }
        System.out.println("Lock released by "+Thread.currentThread().getName());
        notify();
    }
}
