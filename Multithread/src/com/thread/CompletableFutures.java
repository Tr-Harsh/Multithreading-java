package com.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutures {
    public static void main(String[] args) {
        System.out.println("From thread1: "+Thread.currentThread().getName());
        CompletableFuture.supplyAsync(()-> {
            System.out.println("From thread20: "+Thread.currentThread().getName());
            return 21;
        }).thenAccept((Integer i)-> System.out.println("From thread"+i+": "+Thread.currentThread().getName()));
        System.out.println("From thread4: "+Thread.currentThread().getName());
    }

}
