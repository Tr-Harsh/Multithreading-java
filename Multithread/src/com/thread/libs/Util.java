package com.thread.libs;

public class Util {
    public static Integer calculatePrime(int n) {
        int no = 1;
        int noPrime = 0;
        int i;
        while (noPrime < n) {
            no++;
            for (i = 2; i <= no && no % i != 0; i++) {
            }
            if (i == no) {
                noPrime++;
            }
        }
        return no;
    }
}
