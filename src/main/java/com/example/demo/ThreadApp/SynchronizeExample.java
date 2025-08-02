package com.example.demo.ThreadApp;

public class SynchronizeExample {
    public static void main(String[] args) {
        th t= new th();
        t.run();
    }
}

class th{
    public void run(){
        Thread thread1 = new Thread(() -> {
            synchronized (this) {
                System.out.println("Thread 1 is running");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (this) {
                System.out.println("Thread 2 is running");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

}