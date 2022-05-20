package com.FunctionalInterface;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    private final Function<Long, Long> hashFunction;
    private final Supplier<String> supplierFunction;
    private final Predicate<Integer> predicateFunction;

    public Main(Function<Long, Long> hashFunction, Supplier<String> supplierFunction, Predicate<Integer> predicateFunction) {
        this.hashFunction = hashFunction;
        this.supplierFunction = supplierFunction;
        this.predicateFunction = predicateFunction;
    }

    public Long hash(Long obj){
        return hashFunction.apply(obj);
    }

    public String supply(){
        return supplierFunction.get();
    }

    public boolean isEven(Integer i){
        return predicateFunction.test(i);
    }


    public static void main(String[] args) {
        Main main = new Main(obj->Math.abs(obj)*2, ()->"Return from supplier", obj->obj%2==0);
        System.out.println(main.hash(200L));
        System.out.println(main.supply());
        System.out.println(main.isEven(10));
    }
}
