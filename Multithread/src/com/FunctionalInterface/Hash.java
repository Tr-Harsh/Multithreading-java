package com.FunctionalInterface;

public interface Hash {
    String hash(int s);

    static String hashCode(int s){
        return String.valueOf(new Integer(s).hashCode());
    }

    default String defaultHash(){
        return "default";
    }
}
