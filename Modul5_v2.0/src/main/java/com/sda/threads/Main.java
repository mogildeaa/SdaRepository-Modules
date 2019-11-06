package com.sda.threads;

public class Main {

    public static void main(String[] args) throws InterruptedException {
//        sleepThread();
//        countdown();
        Core1 core = new Core1();
        Core2 core2 = new Core2();
        core.start();
        core2.run();
    }

    public static void countdown() throws InterruptedException {
        for(int i = 5; i > 0; i--){
            System.out.println("Bomba explodeaza in: " + i + " secunde.");
            Thread.sleep(1000);
        }
        System.out.println("Allahu akbar!!!");
    }

    private static void sleepThread() throws InterruptedException {
        System.out.println("Incep executie thread");

        //pauza executie pt o secunda
        Thread.sleep(1000);
        System.out.println("Inca execut");
        Thread.sleep(1000);

        System.out.println("Opresc executie");
    }
}
