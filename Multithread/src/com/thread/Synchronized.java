package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable{
    int value = 0;
    final static Integer i = 1;

    public void increment(){
        value++;
    }

    public void decrement(){
        value--;
    }

    @Override
    public void run() {
        synchronized (i) {
            increment();
            System.out.println(Thread.currentThread().getName() + " increment() called: " + this.value);
            decrement();
            System.out.println(Thread.currentThread().getName() + " decrement() called: " + this.value);
        }
    }
}

class LockCounter implements Runnable{
    int value = 0;
    Lock lock = new ReentrantLock();
    public void increment(){
        value++;
    }

    public void decrement(){
        value--;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            increment();
            System.out.println(Thread.currentThread().getName() + " increment() called: " + this.value);
            decrement();
            System.out.println(Thread.currentThread().getName() + " decrement() called: " + this.value);
        } finally {
            lock.unlock();
        }
    }
}

public class Synchronized{
    public static void main(String[] args) {

        Counter counter = new Counter();
        Counter counter1 = new Counter();
        new Thread(counter,"C01").start();
        new Thread(counter,"C02").start();
        new Thread(counter,"C03").start();
        new Thread(counter1,"C11").start();

/*
        LockCounter lc = new LockCounter();
        LockCounter lc1 = new LockCounter();
        new Thread(lc,"C01").start();
        new Thread(lc,"C02").start();
        new Thread(lc,"C03").start();
        new Thread(lc1,"C11").start();
*/

    }
}
