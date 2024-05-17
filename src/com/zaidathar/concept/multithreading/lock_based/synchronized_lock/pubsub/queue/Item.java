package com.zaidathar.concept.multithreading.pubsub.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Item {

    private transient int size = 10;
    private Queue<String> queue = new LinkedList<>();

    public synchronized void publishItem(String item) {

            while(queue.size() >= size){
                try{
                    System.out.println("Queue is full!! start waiting for  "+Thread.currentThread().getName());
                    wait();
                    System.out.println("Wait over, started producing by "+Thread.currentThread().getName());

                }
                catch (InterruptedException e){
                    System.out.println("Exception caught in publishing item "+e.getMessage());
                }
            }
            queue.add(item);
            System.out.println("Item : "+item + " published successfully by "+Thread.currentThread().getName());
            notifyAll();

    }

    public synchronized void consumeItem(){

            while (queue.isEmpty()){
                try{
                    System.out.println("Queue is empty started waiting for "+Thread.currentThread().getName());
                    wait();
                    System.out.println("Wait over, started consuming by "+Thread.currentThread().getName());
                }
                catch (InterruptedException e){
                    System.out.println("Exception caught while consuming item "+e.getMessage());
                }
            }
            String message = queue.poll();
            notifyAll();
            System.out.println("Item consumed : "+message + " by "+ Thread.currentThread().getName());

    }
}
