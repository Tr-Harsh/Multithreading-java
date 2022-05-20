package com.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DataStructres {
//    Map<Integer,Integer> map = new ConcurrentHashMap<>();
    Map<Integer,Integer> map = new HashMap<>();

    public Integer get(Integer key) {
        return map.get(key);
    }

    public void put(Integer key, Integer value) {
        map.put(key, value);
    }

    public static void main(String[] args) {
        DataStructres d = new DataStructres();
        Lock lock = new ReentrantLock();
        Runnable runnable = () ->{
            lock.lock();
            Random rand = new Random();
            int v = rand.nextInt();
            try {
                d.put(v, v);
            } finally {
                System.out.println(Thread.currentThread().getName() + " key: "+ v + " value: " + d.get(v));
                lock.unlock();
            }

        };

        ExecutorService e = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            e.submit(runnable);
        }
    }

}
