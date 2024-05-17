package com.zaidathar.concept.multithreading.lock_based.readwrite_lock;

import java.text.MessageFormat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SharedResource {
    private ReentrantReadWriteLock lock ;
    private String name = "Zaid";
    private String message = "My name is {0}, printed by {1}";
    SharedResource(){
        lock = new ReentrantReadWriteLock();
    }

    SharedResource(ReentrantReadWriteLock lock){
        this.lock = lock;
    }

    public void callMyName(){
        try{
            // Putting shared-lock (Read Lock)
            // Will wait for exclusive-lock to finish

            lock.readLock().lock();

            // No exclusive-lock can access current lock , multiple shared-lock can access

            System.out.println("ReadLock acquired by "+Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println(MessageFormat.format(message,name,Thread.currentThread().getName()));
        }
        catch (Exception e){
            // handle exception
        }
        finally {
            lock.readLock().unlock();
            System.out.println("ReadLock released by "+Thread.currentThread().getName());
        }
    }

    public void updateMyName(String updatedName){
        try{
            // Putting exclusive-lock (Write Lock)
            // Will wait for all sharedLock (Read Lock) to finish

            lock.writeLock().lock();

            // No Shared-lock can access current lock

            System.out.println("WriteLock acquired by "+Thread.currentThread().getName());
            this.name = updatedName;
        }
        catch (Exception e){
            // handle exception
        }
        finally {
            // Releasing exclusive-lock
            lock.writeLock().unlock();

            // All shared-lock can access current lock

            System.out.println("WriteLock released by "+Thread.currentThread().getName());
        }
    }
}
