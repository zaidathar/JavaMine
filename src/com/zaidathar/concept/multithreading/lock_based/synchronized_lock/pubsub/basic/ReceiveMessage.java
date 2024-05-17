package com.zaidathar.concept.multithreading.pubsub.basic;

import com.zaidathar.concept.multithreading.pubsub.basic.MyMessage;

public class ReceiveMessage implements Runnable {
    private MyMessage message;

    ReceiveMessage(MyMessage message){
        this.message = message;
    }

    public void run(){
        System.out.println("Receiving message by "+ Thread.currentThread().getName());
        message.receiveMessage();
        System.out.println("Message received by "+Thread.currentThread().getName());
    }
}
