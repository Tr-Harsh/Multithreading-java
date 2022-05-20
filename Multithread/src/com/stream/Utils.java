package com.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static List<User> getUsers() {
        User user1 = new User(1, "Harsh", 22);
        User user2 = new User(2, "Shakti", 20);
        User user3 = new User(3, "Aditi", 22);
        User user4 = new User(4, "Neha", 28);
        User user5 = new User(5, "Arnav", 16);
        User user6 = new User(6, "Aditya", 16);

        return new ArrayList<>(Arrays.asList(user1, user2, user3, user4, user5,user6));
    }
}
