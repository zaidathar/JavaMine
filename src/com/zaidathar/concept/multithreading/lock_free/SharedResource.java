package com.zaidathar.concept.multithreading.lock_free;

public class SharedResource {
    private int counter = 0;

    SharedResource(){}

    public int getCounter() {
        return counter;
    }

    public void increment() {
//        System.out.println("Thread "+Thread.currentThread().getName()+" calling increment on "+this.counter);
        this.counter += 1 ;
    }
}
