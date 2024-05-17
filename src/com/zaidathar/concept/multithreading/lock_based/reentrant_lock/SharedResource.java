package com.zaidathar.concept.multithreading.lock_based.reentrant_lock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private ReentrantLock lock;

    SharedResource(){
        lock = new ReentrantLock();
    }
    SharedResource(ReentrantLock lock){
        this.lock = lock;
    }

    public void callMyName(){
        try{
            lock.lock();
            System.out.println("Lock acquired by "+Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("My name is Zaid , printed by "+Thread.currentThread().getName());
        }
        catch (Exception e){
            // Handle exception
        }
        finally {
            lock.unlock();
            System.out.println("Lock released by "+Thread.currentThread().getName());

        }
    }
}
