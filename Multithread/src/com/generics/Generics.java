package com.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generics<K,V> {
    private K key;
    private V value;

    public Generics() {
    }

    public Generics(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class GenericsBounded<K extends Number> {
    private K key;

    public GenericsBounded() {
    }

    public GenericsBounded(K key) {
        this.key = key;
    }
    public K getKey() {
        return key;
    }

    public <T extends String> String join(List<K> l){
        return l.stream().map(t->t.toString()).collect(Collectors.joining(":"));
    }
}

class GenericsType<K> {
    private K key;

    public GenericsType() {
    }

    public GenericsType(K key) {
        this.key = key;
    }
    public K getKey() {
        return key;
    }

    public <T extends String> String join(List<K> l){
        return l.stream().map(t->t.toString()).collect(Collectors.joining("-"));
    }

    public Number get(GenericsType<Number> g){
        return g.getKey();
    }
}

class Test{
    public static void main(String[] args) {
        Generics<String, String> g = new Generics<>("Harsh", "Test");
        System.out.println(g.getKey() + " " + g.getValue());
        Generics<String, Integer> g2 = new Generics<>("Harsh2", 2);
        System.out.println(g2.getKey() + " " + g2.getValue());
        Generics<String, Double> g3 = new Generics<>("Harsh", 3.0);
        System.out.println(g3.getKey() + " " + g3.getValue());
        Generics<Integer, String> g4 = new Generics<>(4, "Harsh");
        System.out.println(g4.getKey() + " " + g4.getValue());

        //---------------------------------------------------//

        GenericsBounded<Integer> gb = new GenericsBounded<>(10);
        System.out.println(gb.getKey());

        GenericsBounded<Integer> gbl = new GenericsBounded<>();
        Integer[] l = {1,2,3,4};
        System.out.println(gbl.join(Arrays.asList(l)));

        //---------------------------------------------------//

        GenericsType<Integer> gt = new GenericsType<>(10);
        System.out.println(gt.join(Arrays.asList(l)));

//        System.out.println(gt.get(gt));

    }
}
