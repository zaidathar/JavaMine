package com.zaidathar.concept.multithreading.lock_free;

public class AtomicIssueTesting {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(() ->{
            for(int i = 0 ; i < 170 ; i++){
                sharedResource.increment();
            }
            System.out.println("Counter by "+Thread.currentThread().getName()+" is "+sharedResource.getCounter());
        },"t1");

        Thread t2 = new Thread(() ->{
            for(int i = 0 ; i < 120 ; i++){
                sharedResource.increment();
            }
            System.out.println("Counter by "+Thread.currentThread().getName()+" is "+sharedResource.getCounter());
        },"t2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
