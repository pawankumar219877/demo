package com.example.demo.ThreadApp;

public class SyncClass {
      public synchronized void m1( long timeMilli) throws InterruptedException {
          Thread.sleep(timeMilli);
          System.out.println("synchronized method m1 is called by instance "+timeMilli);
      }

}
