package com.zaidathar.concept.multithreading.lock_based.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private final ReentrantLock lock;
    private final Condition condition;
    private boolean isAvailable = false;

    SharedResource(){
        this.lock = new ReentrantLock();
        condition = lock.newCondition();
    }

    SharedResource(ReentrantLock lock){
        this.lock = lock;
        condition = lock.newCondition();
    }

    public void produce(){
        try{
            lock.lock();
            System.out.println("Produce lock acquired by "+ Thread.currentThread().getName());

            if(isAvailable){
                System.out.println("Produce thread is waiting "+Thread.currentThread().getName());
                condition.await();
            }

            isAvailable = true;
            condition.signal();
        }
        catch (Exception e){
            //handle exception
        }
        finally {
            lock.unlock();
            System.out.println("Produce lock released by "+Thread.currentThread().getName());

        }
    }

    public void consume(){
        try{
            Thread.sleep(1000);
            lock.lock();
            System.out.println("Consume lock acquired by "+Thread.currentThread().getName());

            if(!isAvailable){
                System.out.println("Consume thread is waiting "+Thread.currentThread().getName());
                condition.await();
            }

            isAvailable=false;
            condition.signal();
        }
        catch (Exception e){
            // handle exception
        }
        finally {
            System.out.println("Consume lock released by "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
