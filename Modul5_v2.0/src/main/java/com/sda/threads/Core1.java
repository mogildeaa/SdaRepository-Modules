package com.sda.threads;

public class Core1 extends Thread{

    @Override
    public void run() {
        System.out.println("Thread started");
       for(int i = 5; i > 0; i--){
            System.out.println("Bomba explodeaza in: " + i + " secunde.");
           try {
               Thread.sleep(1000);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
        System.out.println("Allahu akbar!!!");
    }
}
