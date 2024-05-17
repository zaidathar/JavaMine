package com.zaidathar.concept.multithreading.pubsub.queue;

public class PubSub {
    public static void main(String[] args) {
        Item item = new Item();
        Producer producer = new Producer(item);
        Consumer consumer = new Consumer(item);

        Thread producerThread = new Thread(producer,"Producer-Thread");
        Thread consumerThread = new Thread(consumer,"Consumer-Thread");

        producerThread.start();
        consumerThread.start();
    }
}
