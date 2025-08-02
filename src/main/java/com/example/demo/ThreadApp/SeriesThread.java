package com.example.demo.ThreadApp;


import java.util.Arrays;
import java.util.List;

public class SeriesThread {

    public static void main(String[] arg) throws InterruptedException {
        List<Runnable> runnables = Arrays.asList(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("Running thread 1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, () -> {
            try {
                Thread.sleep(200);
                System.out.println("Running thread 2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t1 = new Thread(runnables.get(0));
        Thread t2 = new Thread(runnables.get(1));

        // run thread in series
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        //or run thread in series
        t1.run();
        t2.run();
    }

}
