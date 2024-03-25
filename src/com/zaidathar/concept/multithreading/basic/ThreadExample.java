package com.zaidathar.concept.multithreading.basic;

public class ThreadExample {
    public static void main(String[] args) {
        System.out.println("Main method started by "+ Thread.currentThread().getName());
        ThreadByRunnable runnable = new ThreadByRunnable();

        Thread thread = new Thread(runnable);
        thread.start();

        Thread t1 = new Thread("my-thread-1"){
            @Override
            public void run(){
                System.out.println("Running thread : "+Thread.currentThread().getName());
            }
        };

        // we can invoke run method multiple time as it will run by current thread. No new thread created.
        t1.run();
        t1.run();

        t1.start();

        // we can't invoke start method more than 1 time. It will give exception.
        try{
            t1.start();
        }
        catch (IllegalThreadStateException e){
            System.out.println("Exception caught while starting thread : ");
        }
        System.out.println("Main method end by "+ Thread.currentThread().getName());

    }
}
