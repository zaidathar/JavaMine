package com.zaidathar.concept.multithreading.lock_free.atomic_integer;

import java.util.concurrent.atomic.AtomicInteger;

public class SharedResource {
    SharedResource(){}
    private AtomicInteger counter = new AtomicInteger(0);

    public AtomicInteger getCounter(){
        return counter;
    }

    public void increment(){
        counter.getAndIncrement();
    }

}
