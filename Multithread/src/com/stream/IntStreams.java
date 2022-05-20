package com.stream;

import java.util.stream.IntStream;

public class IntStreams {
    public static void main(String[] args) {
        IntStream.range(1,11)
                .filter(i->i%2==0)
                .average()
                .ifPresent(System.out::println);
    }
}
