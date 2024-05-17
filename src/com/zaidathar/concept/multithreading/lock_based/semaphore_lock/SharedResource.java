package com.zaidathar.concept.multithreading.lock_based.semaphore_lock;

import java.util.concurrent.Semaphore;

public class SharedResource {
    private Semaphore lock;
    private final String name = "Zaid";
    SharedResource(){
        lock = new Semaphore(2);
    }

    SharedResource(Semaphore lock){
        this.lock = lock;
    }

    public void callMyName(){
        try{
            lock.acquire();
            System.out.println("Semaphore lock acquired by "+Thread.currentThread().getName());
            System.out.println("My name is "+name+", printed by "+Thread.currentThread().getName());
            Thread.sleep(10000);
        }
        catch (Exception e){
            // handle exception
        }
        finally {
            lock.release();
            System.out.println("Semaphore lock released by"+Thread.currentThread().getName());
        }
    }

}
