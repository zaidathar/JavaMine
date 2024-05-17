package com.zaidathar.concept.multithreading.lock_based.readwrite_lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);

        Thread t1 = new Thread(() ->{
            resource1.callMyName();
        },"T1");

        Thread t2 = new Thread(() ->{
            resource1.callMyName();
        },"T2");

        Thread t3 = new Thread(() ->{
            resource1.updateMyName("Zaid Athar");
        },"T3");



        t1.start();
        t2.start();
        t3.start();
    }
}
