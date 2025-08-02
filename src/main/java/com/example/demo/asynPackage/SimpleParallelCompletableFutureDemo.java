package com.example.demo.asynPackage;

import java.util.concurrent.*;

import com.example.demo.asynPackage.model.Account;
import com.example.demo.asynPackage.utils.Printer;
public class SimpleParallelCompletableFutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
      //  parallelAccountExample();
        seriesAccountExample();

    }
    public  static void AirlineExample() throws ExecutionException, InterruptedException {
        System.out.println("Running a set of simple Parallel CompletableFutures\n");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        // Create the airline reservation CompletableFuture
        CompletableFuture<String> airlineFuture =
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return new TimedReservation().makeReservation("Airline");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        executor);
        // Create the hotel reservation CompletableFuture
        CompletableFuture<String> hotelFuture =
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return new TimedReservation().makeReservation("Hotel");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        executor);
        // Create the car rental reservation CompletableFuture
        CompletableFuture<String> carRentalFuture =
                CompletableFuture.supplyAsync(
                        () -> {
                            try {
                                return new TimedReservation().makeReservation("Car Rental");
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        },
                        executor);

        // Wait for all the CompletableFutures to complete
        CompletableFuture.allOf(airlineFuture, hotelFuture, carRentalFuture).join();

        Printer.printResult(String.valueOf(airlineFuture.get()));
        Printer.printResult(String.valueOf(hotelFuture.get()));
        Printer.printResult(String.valueOf(carRentalFuture.get()));

        executor.shutdown();
        System.exit(0);
    }
    public  static void parallelAccountExample() throws ExecutionException, InterruptedException {
        Account ac1 =new Account(1l,1l,100,23.04);
        Account ac2 =new Account(2l,2l,150,13.04);
        Account ac3 =new Account(3l,3l,80,70.04);
        ExecutorService accountService = Executors.newFixedThreadPool(3);

       // CompletableFuture<Integer> completableFuture = empService.
        CompletableFuture<Double>   completableFuture1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return   ac1.getPrice();
        }, accountService);

        CompletableFuture<Double>   completableFuture2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return   ac2.getPrice();
        }, accountService);

        CompletableFuture<Double>   completableFuture3 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return   ac3.getPrice();
        }, accountService);
        CompletableFuture.allOf(completableFuture1,completableFuture2,completableFuture3).get();
        // total sum after 20000 ms
        System.out.println(completableFuture1.get()+completableFuture2.get()+completableFuture3.get());
    }

    public  static void seriesAccountExample() throws ExecutionException, InterruptedException {
        Account ac1 =new Account(1l,1l,100,23.04);
        Account ac2 =new Account(2l,2l,150,13.04);
        Account ac3 =new Account(3l,3l,80,70.04);
        ExecutorService accountService = Executors.newFixedThreadPool(3);

        // CompletableFuture<Integer> completableFuture = empService.
        CompletableFuture<Double>   completableFuture1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
                System.out.println("after= 1000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return   ac1.getPrice();
        }, accountService).thenApplyAsync((oldprice)->{
            try {
                Thread.sleep(8000);
                System.out.println("after= 18000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  oldprice + ac2.getPrice();
        }).thenApplyAsync((oldprice)->{
            try {
                Thread.sleep(20000);
                System.out.println("after= 38000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  oldprice + ac3.getPrice();
        });

        // total sum after 20000 ms
        System.out.println(completableFuture1.get());
    }

    public  static void seriesAccountExample2() throws ExecutionException, InterruptedException {
        Account ac1 =new Account(1l,1l,100,23.04);
        Account ac2 =new Account(2l,2l,150,13.04);
        Account ac3 =new Account(3l,3l,80,70.04);
        ExecutorService accountService = Executors.newFixedThreadPool(3);

        // CompletableFuture<Integer> completableFuture = empService.
        CompletableFuture<Double>   completableFuture1 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
                System.out.println("after= 1000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return   ac1.getPrice();
        }, accountService).thenApplyAsync((oldprice)->{
            try {
                Thread.sleep(8000);
                System.out.println("after= 18000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  oldprice + ac2.getPrice();
        } ).thenApplyAsync((oldprice)->{
            try {
                Thread.sleep(20000);
                System.out.println("after= 38000");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return  oldprice + ac3.getPrice();
        });

        // total sum after 20000 ms
        System.out.println(completableFuture1.get());
    }
}