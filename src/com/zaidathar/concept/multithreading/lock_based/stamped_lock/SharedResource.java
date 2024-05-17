package com.zaidathar.concept.multithreading.lock_based.stamped_lock;

import java.security.SecureRandom;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {
    private int counter = 0;

    private StampedLock lock;

    SharedResource(){
        lock = new StampedLock();
    }

    SharedResource(StampedLock lock){
        this.lock = lock;
    }

    public void updateCounter(int number){
        try{
            long stamp = lock.tryOptimisticRead();
            System.out.println("Optimistic Read");
            Thread.sleep(6000);
            if(lock.validate(stamp)){
                System.out.println("Updating value of counter to "+number);
                this.counter = number;
            }
            else{
                System.out.println("Rollback started , dirty commit found");

            }

        }
        catch (Exception e){
            // handle exception
        }
    }

    public void updateRandomCounter() {
        long stamp = lock.writeLock();
        System.out.println("Write lock acquired by "+ Thread.currentThread().getName());
        try{
            int random = new SecureRandom().nextInt();
            System.out.println("updating value of counter to "+random);
            this.counter = random;
            Thread.sleep(3000);
        }
        catch (Exception e){

        }
        finally {
            lock.unlock(stamp);
            System.out.println("WriteLock released by "+Thread.currentThread().getName());
        }
    }
}
