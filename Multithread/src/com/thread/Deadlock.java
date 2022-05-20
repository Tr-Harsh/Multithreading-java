package com.thread;

public class Deadlock {
    final Integer a = 1;
    final Integer b = 2;
    public void methodA(){
        synchronized (a){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(b){
                System.out.println(Thread.currentThread().getName()+" MethodA() called");
            }
        }
    }

    public void methodB(){
        synchronized (b){
            synchronized(a){
                System.out.println(Thread.currentThread().getName()+ " MethodB() called");
            }
        }
    }


    public static void main(String[] args) {
        Deadlock d = new Deadlock();
        Runnable r1 = d::methodA;
        Runnable r2 = d::methodB;

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
