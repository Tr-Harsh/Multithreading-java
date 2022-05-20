package com.FunctionalInterface;

public class HashMain {
    public static void main(String[] args) {
        Hash hash = (i)->String.valueOf(i%10+100);
        System.out.println(hash.hash(10));
        System.out.println(hash.hash(5));
        System.out.println(hash.hash(15));
        System.out.println(hash.defaultHash());
        System.out.println(Hash.hashCode(2));

    }
}
