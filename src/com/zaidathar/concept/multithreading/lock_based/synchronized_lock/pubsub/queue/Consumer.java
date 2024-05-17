package com.zaidathar.concept.multithreading.pubsub.queue;

public class Consumer implements Runnable{

    private Item item;

    Consumer(Item item){
        this.item = item;
    }

    @Override
    public void run(){
        int size = 20;
        System.out.println("Running consumer");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Sleeping exception");
        }
        System.out.println("Started consuming ...");
        while (size > 0){

            item.consumeItem();
            size--;
        }
    }
}
