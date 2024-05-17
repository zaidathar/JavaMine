package com.zaidathar.concept.multithreading.lock_based.stamped_lock;

import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        StampedLock lock = new StampedLock();

        SharedResource resource1 = new SharedResource(lock);
        SharedResource resource2 = new SharedResource(lock);
        SharedResource resource3 = new SharedResource(lock);

        Thread t1 = new Thread(
                ()->{
                    resource1.updateCounter(20);
                },
                "T1"
        );

        Thread t2 = new Thread(
                ()->{
                    resource2.updateRandomCounter();
                },
                "T2"
        );

        Thread t3 = new Thread(()->{
            resource3.updateCounter(40);
        },"T3");

        t2.start();
        Thread.sleep(1000);
        t1.start();
        Thread.sleep(4000);
        t3.start();
    }
}
