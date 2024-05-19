package com.zaidathar.concept.multithreading.future;

import com.zaidathar.utils.StringUtils;

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureMain {
    static {
        executor = new ThreadPoolExecutor(
                3,6,
                5, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy()
        );
    }

    private static ThreadPoolExecutor executor;
    private static final String LINE_BREAK = "\n--------------------------\n";

    public static void CFSupplyAsyncWithoutExecutor(){

        // It takes supplier and execute task on a worker thread from ForkJoinPool
        CompletableFuture<String> futureNumber = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync without executor run by "+Thread.currentThread().getName() );
           return StringUtils.generateNumberString(12);
        });

        try {
            String number = futureNumber.get();
            System.out.println("Number from future "+number);
        }catch (Exception e){
            System.out.println("Exception caught in supplyAsync(supplier)");
        }
        System.out.println(LINE_BREAK);

    }

    public static void CFSupplyAsyncWithExecutor(){

        CompletableFuture<List<Integer>> futureList = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync with executor run by "+Thread.currentThread().getName() );
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync");
            }
            return IntStream.range(1,6).boxed().collect(Collectors.toList());
        },executor);

        try{

            List<Integer> numberList = futureList.get();
            System.out.println("Number list from future "+numberList.toString());
        }
        catch (Exception e){
            System.out.println("Exception caught in supplyAsync(supplier,executor)");
        }
        System.out.println(LINE_BREAK);

    }

    public static void CFThenApply(){

        CompletableFuture<List<Integer>> futureList = CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenApply run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync");
            }
            return IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        });

        /*
         This is synchronous call , i.e. task will be executed using same thread from previous completed async task

         Note : You might see thread name as "main" sometime if supplyAsync completed quickly (check by commenting sleep method)
                1. supplyAsync starts an asynchronous task in the ForkJoinPool.
                2. The main thread continues and registers the thenApply callback.
                3. The asynchronous task completes quickly.
                4. The thenApply callback is executed immediately in the main thread because
                   the main thread is the one that registered the callback.
        */

        CompletableFuture<List<Integer>> futureSquaredList = futureList.thenApply((list) ->{
            System.out.println("then apply executed by "+Thread.currentThread().getName());

            return list.stream().map(n -> n*n).collect(Collectors.toList());
        });

        try{
            List<Integer> squaredList = futureSquaredList.get();
            System.out.println("Squared list from future and theApply "+squaredList);
        }
        catch (Exception e){
            System.out.println("Exception caught in thenApply()");
        }
        System.out.println(LINE_BREAK);

    }

    public static void CFThenApplyAsync(){
        // We also can pass our own executor JVM will take thread from executor instead of ForkJoinPool

        CompletableFuture<List<Integer>> futureSquaredList = CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenApplyAsync run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync for thenApplyAsync");
            }
            return IntStream.rangeClosed(1,10).boxed().collect(Collectors.toList());
        },executor).thenApplyAsync((list)->{
            System.out.println("thenApplyAsync executed by "+Thread.currentThread().getName());

            return list.stream().map(n -> n*n).collect(Collectors.toList());
        },executor);


        try{
            List<Integer> squaredList = futureSquaredList.get();
            System.out.println("Squared list from future and theApplyAsync "+squaredList);
        }
        catch (Exception e){
            System.out.println("Exception caught in thenApplyAsync()");
        }
        System.out.println(LINE_BREAK);


    }

    public static void CFThenCompose(){
        // This is synchronous task operation
        // you can't pass executor in theCompose as it synchronous . thenComposeAsync accepts executor
        // It chains all task using internal stack

        CompletableFuture<String> futureString = CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenCompose run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync for thenCompose");
            }
            return "Hi ";
        }).thenCompose((String str)->{
            return CompletableFuture.supplyAsync(()->{
                System.out.println("Supply async in thenCompose 1 run by "+Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (Exception e){
                    System.out.println("Exception caught in supplyAsync for thenCompose 2");
                }
                return "there !!, ";
            });
        }).thenCompose((String str)->{
            return CompletableFuture.supplyAsync(()->{
                System.out.println("Supply async in thenCompose 2 run by "+Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (Exception e){
                    System.out.println("Exception caught in supplyAsync for thenCompose 2");
                }
                return "how are you?";
            });
        });

        try{
            String string = futureString.get();
            System.out.println("Future String "+string);

        }catch(Exception e){

        }
        System.out.println(LINE_BREAK);

    }

    public static void CFThenComposeAsync(){
        // This is synchronous task operation

        CompletableFuture<String> futureString = CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenComposeAsync run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync for thenComposeAsync");
            }
            return "Hi ";
        }).thenComposeAsync((String str)->{
            return CompletableFuture.supplyAsync(()->{
                System.out.println("Supply async in thenComposeAsync 1 run by "+Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (Exception e){
                    System.out.println("Exception caught in supplyAsync for thenComposeAsync 1");
                }
                return "there !!, ";
            },executor);
        }).thenComposeAsync((String str)->{
            return CompletableFuture.supplyAsync(()->{
                System.out.println("Supply async in thenComposeAsync 2 run by "+Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                }
                catch (Exception e){
                    System.out.println("Exception caught in supplyAsync for thenComposeAsync 2");
                }
                return "how are you?";
            });
        },executor);

        try{
            String string = futureString.get();
            System.out.println("Future String "+string);

        }catch(Exception e){

        }
        System.out.println(LINE_BREAK);

    }

    public static void CFThenAccept(){
        // thenAccept is synchronous , it will be executed on same thread which completed previous future task

        CompletableFuture<Void> future = CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenAccept run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync for thenAccept");
            }
            return "Hi";
        }).thenAccept((String val)->{
            System.out.println("thenAccept call by "+Thread.currentThread().getName());
            String finalString = val + ", accepted";
            System.out.println("final string : "+finalString);
        });

        try{
            future.get();
        }
        catch (Exception e){
            System.out.println("Exception caught in thenApply");
        }

        System.out.println(LINE_BREAK);

    }

    public static void CFThenAcceptAsync(){
        // thenAcceptAsync is asynchronous it will be executed on new thread

        CompletableFuture<Void> future =  CompletableFuture.supplyAsync(()->{
            System.out.println("Supply async for thenAcceptAsync run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync for thenAcceptAsync");
            }
            return "Hi";
        }).thenAcceptAsync((String val)->{
            System.out.println("thenAcceptAsync call by "+Thread.currentThread().getName());
            String finalString = val + ", accepted";
            System.out.println("final string : "+finalString);
        });

        try{
            future.get();
        }
        catch (Exception e){
            System.out.println("Exception caught in thenApplyAsync");
        }

        System.out.println(LINE_BREAK);
    }

    public static void CFThenCombine(){

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync1 for thenCombine run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync1 for thenCombine");
            }
            return "Hi";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync2 for thenCombine run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync2 for thenCombine");
            }
            return " there !!";
        });

        // This will combined and executed by thread of future1
        CompletableFuture<String> combinedFuture = future1.thenCombine(future2, (String s1, String s2) -> {
            System.out.println("Combining future by "+Thread.currentThread().getName());
            return s1+s2;
        });

        try{
            String combinedString = combinedFuture.get();
            System.out.println("Combined String from futures : "+combinedString);
        }
        catch (Exception e){
            System.out.println("Exception caught in theCombine");
        }

        System.out.println(LINE_BREAK);
    }

    public static void CFThenCombineAsync(){

        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync1 for thenCombineAsync run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync1 for thenCombineAsync");
            }
            return "Hi";
        },executor);

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            System.out.println("supplyAsync2 for thenCombineAsync run by "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
            }
            catch (Exception e){
                System.out.println("Exception caught in supplyAsync2 for thenCombineAsync");
            }
            return " there !!";
        },executor);

        // This will be combined and executed on different thread from executor
        CompletableFuture<String> combinedFuture = future1.thenCombineAsync(future2, (String s1, String s2) -> {
            System.out.println("Combining future by "+Thread.currentThread().getName());
            return s1+s2;
        },executor);

        try{
            String combinedString = combinedFuture.get();
            System.out.println("Combined String from futures : "+combinedString);
        }
        catch (Exception e){
            System.out.println("Exception caught in theCombineAsync");
        }


        System.out.println(LINE_BREAK);
    }
    public static void main(String[] args) {
        CFSupplyAsyncWithoutExecutor();
        CFSupplyAsyncWithExecutor();
        CFThenApply();
        CFThenApplyAsync();
        CFThenCompose();
        CFThenCompose();
        CFThenComposeAsync();
        CFThenAccept();
        CFThenAcceptAsync();
        CFThenCombine();
        CFThenCombineAsync();
        executor.shutdown();
    }
}
