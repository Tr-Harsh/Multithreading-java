package com.thread;

import com.thread.libs.Comparators;
import com.thread.libs.User;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class ConcurrentCollections
{
    private final Map<String, String> userMap = new ConcurrentHashMap<>();
    private final Map<String, String> sortedUserMap = new ConcurrentSkipListMap<>(new Comparators.UserComparator());
    public static void main( String[] args ) {
        ConcurrentCollections app = new ConcurrentCollections();
        app.initUserMap();
        app.initSortedUserMap();
    }

    public void initUserMap(){
        User user = new User(UUID.randomUUID().toString(), "Harsh");
        User user2 = new User(UUID.randomUUID().toString(), "Neha");
        User user3 = new User(UUID.randomUUID().toString(), "Aditi");
        userMap.put(user.getId(),user.getName());
        userMap.put(user2.getId(),user2.getName());
        userMap.put(user3.getId(),user3.getName());
        System.out.println(userMap);
    }

    public void initSortedUserMap(){
        User user = new User(UUID.randomUUID().toString(), "Harsh");
        User user2 = new User(UUID.randomUUID().toString(), "Neha");
        User user3 = new User(UUID.randomUUID().toString(), "Aditi");
        sortedUserMap.put(user.getId(),user.getName());
        sortedUserMap.put(user2.getId(),user2.getName());
        sortedUserMap.put(user3.getId(),user3.getName());
        System.out.println(sortedUserMap);
    }
}
