package com.zaidathar.concept.multithreading.pubsub.queue;

import com.zaidathar.utils.StringUtils;

public class Producer implements Runnable {

    private Item item;

    Producer(Item item){
        this.item = item;
    }

    @Override
    public void run() {
        int size = 20;
        System.out.println("Running producer ...");
        while (size > 0){
            String message = StringUtils.generateRandomString(10);
            item.publishItem(message);
            size--;
        }
    }
}
