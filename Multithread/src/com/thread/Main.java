package com.thread;

import com.thread.libs.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        Runnable reporterRunnabe = () -> {
            try {
                while (true) {
                    Thread.sleep(5000);
                    reporter(threads);
                }
            } catch (InterruptedException e) {
                System.out.println("Reporter Thread interrupted");
            }
        };

        Thread reporterThread = new Thread(reporterRunnabe);
        reporterThread.start();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter number: ");
            int n = scanner.nextInt();
            if (n == 0) {
                try {
                    reporterThread.interrupt();
                    waitForAllThread(threads);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            Runnable r = () -> {
                int number = Util.calculatePrime(n);
                System.out.println(Thread.currentThread().getName() + " " + n + "th prime is: " + number);
            };
            Thread t = new Thread(r);
            threads.add(t);
            t.start();
        }
    }

    public static void reporter(List<Thread> threads) {
        threads.forEach(t -> System.out.println("STATUS of " + t.getName() + " is " + t.getState()));
    }

    public static void waitForAllThread(List<Thread> threads) throws InterruptedException {
        for (Thread t : threads) t.join();
    }
}
