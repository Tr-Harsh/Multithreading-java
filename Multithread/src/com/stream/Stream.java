package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stream {
    public static void main(String[] args) {
        List<User> users = Utils.getUsers();
        users.stream()
                .filter(u->{
                    System.out.println("Filter:" + u.getName());
                    return u.getName().startsWith("A");
                })
                .sorted((u1,u2)->{
                    System.out.println("Sort:" + u1.getName()+ " " + u2.getName());
                    return u2.getAge().compareTo(u1.getAge());
                })
                .forEach(u->{
                    System.out.println("ForEach:" +u.getName());
                });
    }

}
