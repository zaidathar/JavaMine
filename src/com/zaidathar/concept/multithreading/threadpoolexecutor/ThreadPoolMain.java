package com.zaidathar.concept.multithreading.threadpoolexecutor;

import java.util.concurrent.*;

public class ThreadPoolMain {

    public static void threadPoolUsingDefault(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,4,
                5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );

        for(int i = 0 ; i<=5 ;i++){
            executor.submit(() ->{
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    System.out.println("Exception caught ");
                }
                System.out.println("Task processing by "+Thread.currentThread().getName());
            });
        }
        executor.shutdown();

    }

    public static void threadPoolUsingCustom(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,4,
                5,TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(),
                new CustomRejectHandler()
        );

        for(int i = 0 ; i<=6 ;i++){
            executor.submit(()->{
               try{
                   TimeUnit.SECONDS.sleep(5);
               }catch (Exception e){
                   System.out.println("Exception caught in threadPoolUsingCustom "+e.getMessage());
               }
                System.out.println("Task processing by "+Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
    public static void main(String[] args) {
        threadPoolUsingDefault();
        threadPoolUsingCustom();
    }
}
