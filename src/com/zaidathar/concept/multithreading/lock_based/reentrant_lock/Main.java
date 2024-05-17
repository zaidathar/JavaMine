package com.zaidathar.concept.multithreading.lock_based.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        // lock should be same for all object of shared resource

        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);

        Thread t1 = new Thread(() ->{
            resource1.callMyName();
        },"T1");

        Thread t2 = new Thread(() ->{
            resource2.callMyName();
        },"T2");

        t1.start();
        t2.start();
    }
}
