package com.thread;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThread {
    public static void main(String[] args) {
        Runnable r = ()-> System.out.println(Thread.currentThread().getName()+" scheduled at "+ new Date());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        r.run();
        executor.schedule(r,2, TimeUnit.SECONDS);
        executor.schedule(r,4, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
