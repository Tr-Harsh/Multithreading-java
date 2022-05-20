package com.stream;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class AdvanceStreams {
    public static void main(String[] args) {
        List<User> users = Utils.getUsers();
        Map<Integer,String> users2= users.stream()
                .filter(u -> u.getName().startsWith("A"))
                .collect(Collectors.toMap(
                        User::getId,
                        User::getName
                ));
        System.out.println(users2);
    }
}
