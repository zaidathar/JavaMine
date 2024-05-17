package com.zaidathar.concept.multithreading.pubsub.basic;

public class MyMessage{

    private boolean isMessageReceived;

    public synchronized void sendMessage(){
        System.out.println("Sending message...");
        isMessageReceived = true;
        notifyAll();
        System.out.println("Message sent !!");
    }

    public synchronized void receiveMessage(){
        System.out.println("Receiving messages ...");

        while(!isMessageReceived){
            try{
                wait();
            }
            catch (InterruptedException e){
                System.out.println("Exception in receiving message : "+e.getMessage());
            }
        }

        isMessageReceived = false;

    }

    public synchronized void printMessage(){
        System.out.println("Printing message for "+Thread.currentThread().getName());
    }


}
