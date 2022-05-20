package com.thread;

public class Execution {
    public static void main(String[] args) {
        System.out.println("Execution 1 done by: "+Thread.currentThread().getName());
        Runnable r = ()-> System.out.println("Runnable Execution done by: "+Thread.currentThread().getName());
        new Thread(r).start();
        System.out.println("Execution 2 done by: "+Thread.currentThread().getName());
    }
}
