package com.example.demo.asynPackage;

import java.util.concurrent.*;

public class CallableExample {
    public static void main(String[] arg) throws ExecutionException, InterruptedException {

        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<String> futDat = es.submit(new CallableMessage());

       System.out.println(futDat.get());
        System.out.println("pawan");
    }
}

class CallableMessage implements Callable<String> {
    public String call() throws Exception{
        Thread.sleep(12000);
        return "Hello World!";
    }
}
