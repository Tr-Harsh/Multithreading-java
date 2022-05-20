package com.thread.libs;

import java.util.Comparator;

public class Comparators {
    public static class UserComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
