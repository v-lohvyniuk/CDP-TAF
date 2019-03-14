package com.cdp.taf.api;

public class Counter {

    static ThreadLocal<Integer> counter = ThreadLocal.withInitial(() -> 0);

    public static void updateCounter() {
        counter.set(counter.get() + 1);
    }

    public static void resetCounter() {
        counter.set(0);
    }

    public static Integer getCounter() {
        return counter.get();
    }
}