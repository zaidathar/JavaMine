package com.zaidathar.concept.multithreading.deadlock;

public class DeadLockBySuspend {
    public static void main(String[] args) throws InterruptedException {
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(
                () -> {
                    System.out.println("Running thread 1");
                    sharedResource.printValue();
                },
                "T1"
        );
        Thread th2 = new Thread(
                () ->{
                    System.out.println("Running thread 2");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                      // Exception handling
                    }
                    sharedResource.printValue();

                },
                "T2"
        );

        th1.start();
        th2.start();
        Thread.sleep(3000);
        th1.suspend();
        System.out.println("Exiting main thread");
    }
}
