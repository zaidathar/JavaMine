package com.zaidathar.concept.multithreading.pubsub.basic;

import com.zaidathar.concept.multithreading.pubsub.basic.MyMessage;

public class SendMessage implements Runnable {
    private MyMessage message;

    SendMessage(MyMessage message){
        this.message = message;
    }

    public void run(){
        System.out.println("Send method call ");

        try {
            System.out.println(Thread.currentThread().getName()+" Sleeping .....");
            Thread.sleep(600L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" send message");
        message.sendMessage();

    }
}
