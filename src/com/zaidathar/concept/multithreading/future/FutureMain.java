package com.zaidathar.concept.multithreading.future;

import com.zaidathar.concept.multithreading.threadpoolexecutor.CustomRejectHandler;
import com.zaidathar.concept.multithreading.threadpoolexecutor.CustomThreadFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureMain {

    public static void futureWithRunnable(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,4,
                5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );


        Future<?> futureObj = executor.submit(()->{
            try{
                TimeUnit.SECONDS.sleep(10);
            }catch (Exception e){
                System.out.println("Exception caught ");
            }
            System.out.println("Task processing by "+ Thread.currentThread().getName());
        });

        System.out.println("Is task done ? "+futureObj.isDone());

        try {
            //it will wait for 2 second to get task and get timeout exception
            futureObj.get(2,TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("Timeout while getting future");
        }
        catch (Exception e){
            System.out.println("Exception while getting future ");
        }

        try {
            // it will wait further so executor can finish task
            Object object = futureObj.get();

            // Object will be null as runnable don't return value
            System.out.println("Object is null "+(object == null));

        } catch (Exception e){
            System.out.println("Exception caught while getting future");
        }

        System.out.println("Is task done "+futureObj.isDone());
        System.out.println("Is task cancelled "+futureObj.isCancelled());

        executor.shutdown();
    }

    public static void futureWithRunnableWorkAroundObject(){

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,4,
                5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new CustomThreadFactory(),
                new CustomRejectHandler()
        );

        List<Integer> list = new ArrayList<>();

        // It will work around list runnable will not return list
        // FutureTask will return same list after completing the task
        Future<List<Integer>> futureObj = executor.submit(new MyRunnable(list),list);

        try{
            // if you get result from future
            List<Integer> res = futureObj.get();
            System.out.println(res);

            // check existing list
            System.out.println(list);

            System.out.println("Both list are equal ? "+list.equals(res));
        }catch (Exception e){
            System.out.println("Exception caught ");
        }

        executor.shutdown();
    }

    public static void futureWithCallable(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,4,
                5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                new CustomThreadFactory(),
                new CustomRejectHandler()
        );


        // Using callable to get future result
        Future<List<Integer>> futureSquareList = executor.submit(()->{
            System.out.println("Callable future");
            List<Integer> squareList = IntStream.range(1,10)
                    .mapToObj(a -> a*a)
                    .collect(Collectors.toList());

            return squareList;

        });

        try{
            // Now we are using callable and it will return a value
            List<Integer> squareList =futureSquareList.get();
            System.out.println(squareList);
        }catch (Exception e){
            System.out.println("Exception caught");
        }

        executor.shutdown();
    }

    public static void main(String[] args) {
        futureWithRunnable();
        futureWithRunnableWorkAroundObject();
        futureWithCallable();
    }
}

class MyRunnable implements Runnable{

    private List<Integer> list;

    public MyRunnable(List<Integer> list){
        this.list = list;
    }
    @Override
    public void run() {
        System.out.println("Run method of MyRunnable");
        list.add(200);
        list.add(900);
    }
}
