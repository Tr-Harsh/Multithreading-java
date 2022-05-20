package com.FunctionalInterface;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Lambdas {

    public static void main(String[] args) {
        PriorityQueue<User> q = new PriorityQueue<>(Comparator.comparingInt(User::getAge));
        q.add(new User("1", 10));
        q.add(new User("2", 30));
        q.add(new User("3", 20));
        q.add(new User("4", 40));

        while(!q.isEmpty()) {
            User u = q.poll();
            System.out.println(u.getUserName()+ " "+u.getAge() + " " + u.hashCode());
        }
    }
}
