package com.thread;
import java.util.concurrent.*;

public class Callables {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<String> c = ()-> {
            Thread.sleep(1000);
            System.out.println("Inside callable: "+ Thread.currentThread().getName());
            return "Return from callable";
        };
        Future<String> futureString = executorService.submit(c);
        System.out.println("From thread: "+ Thread.currentThread().getName());
        System.out.println(futureString.get());
        System.out.println("From thread: "+ Thread.currentThread().getName());

    }
}
