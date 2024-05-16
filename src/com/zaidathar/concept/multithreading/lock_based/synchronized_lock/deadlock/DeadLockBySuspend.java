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

        // Daemon thread , when all user thread finished their task it will automatically close
        th1.setDaemon(true);

        // starting threads
        th1.start();

        /**
         // As only main thread is running now
         //th2.start();

         // Thread T1 will stop immediately as no user thread remains working
         // If T2 is waiting for T1 to finish its task , despite closing of Main-Thread T1 will run
         // and execute all logic as 1 user thread is active and running i.e. T2

         */

        /**
            // Main Thread will wait for th1 and th2 to finish their tasks.
            th1.join();
            th2.join();
         */


        /**
            // suspend and resume is deprecated as it doesn't release monitor lock
            Thread.sleep(3000);
            th1.suspend();

            Thread.sleep(2000);
            th1.resume();

         */

        System.out.println("Exiting main thread");
    }
}
