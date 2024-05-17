package com.zaidathar.concept.multithreading.lock_based.condition;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        SharedResource resource1 = new SharedResource(lock);

        Thread t1 = new Thread(() ->{
            for (int i = 0; i < 3; i++) {
                resource1.produce();
            }
        },"T1");

        Thread t2 = new Thread(() ->{
            for (int i = 0; i < 3; i++) {
                resource1.consume();

            }
        },"T2");


        t1.start();
        t2.start();
    }
}
