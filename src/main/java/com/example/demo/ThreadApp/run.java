package com.example.demo.ThreadApp;


public class run {
    public static void main(String[] arg){
        synchronizedThreadExampleForTwoInstance();
    }

    public  static void synchronizedThreadExample(){
        String msg ="hi";
        Thread th1 = new Thread(()->{
            synchronized (msg){
                System.out.println(msg);
            }
        });
        String msg2 ="buy";
        Thread th2 = new Thread(()->{
            synchronized (msg2){
                System.out.println(msg2);
            }
        });
        th1.start();
        th2.start();
    }

    public  static void synchronizedThreadExampleForTwoInstance(){
        SyncClass s1 = new SyncClass() ;

        Thread t = new Thread(()->{
            try {
                s1.m1(15000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
       System.out.println(System.getProperty("java.class.path"));
        SyncClass s2 = new SyncClass() ;
        Thread t2 = new Thread(()->{
            try {
                s2.m1(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t2.start();

    }
}
