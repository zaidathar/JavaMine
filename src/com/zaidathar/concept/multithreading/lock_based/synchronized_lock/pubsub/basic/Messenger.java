package com.zaidathar.concept.multithreading.pubsub.basic;

public class Messenger{

    public static void main(String[] args) {
        MyMessage message = new MyMessage();

        Thread sendMessageThread = new Thread(new SendMessage(message));
        Thread receiveMessageThread = new Thread(new ReceiveMessage(message));

        sendMessageThread.start();
        receiveMessageThread.start();
    }
}
