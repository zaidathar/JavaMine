package com.zaidathar.concept.multithreading.lock_based.semaphore_lock;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        // Two thread allowed to access critical section simultaneously
        Semaphore lock = new Semaphore(2);

        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);
        SharedResource resource3 = new SharedResource(lock);

        Thread t1 = new Thread(()->{
            resource1.callMyName();
        },"T1");

        Thread t2 = new Thread(()->{
            resource2.callMyName();
        },"T2");

        Thread t3 = new Thread(()->{
            resource3.callMyName();
        },"T3");

        t1.start();
        t2.start();
        t3.start();
    }
}
