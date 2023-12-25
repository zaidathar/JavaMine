package com.zaidathar.threads;

public class EvenAndOddBy2Thread implements Runnable{
    Object object;
    static int count = 1;
    EvenAndOddBy2Thread(Object object){
        this.object = object;
    }
    @Override
    public void run() {
        while(count < 10){
            String threadName = Thread.currentThread().getName();
            if(count % 2 == 0 && threadName.equals("even")){
                synchronized (object){
                    System.out.println("Thread "+threadName+" : count "+count);
                    count++;
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            if(count%2 != 0 &&threadName.equals("odd")){
                synchronized (object){
                    System.out.println("Thread "+threadName+" : count "+count);
                    count++;
                    object.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Runnable r1 = new EvenAndOddBy2Thread(object);
        Runnable r2 = new EvenAndOddBy2Thread(object);

        new Thread(r1,"even").start();
        new Thread(r2, "odd").start();

    }
}
