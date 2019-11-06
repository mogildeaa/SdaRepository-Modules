package com.sda.threads;

public class Core2 implements Runnable {
    @Override
    public void run() {
        System.out.println("Core2 start running");
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Core2 finished running");
    }
}
