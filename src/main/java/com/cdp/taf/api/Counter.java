package com.cdp.taf.api;

import java.util.Objects;

public class Counter {

    static ThreadLocal<Integer> counter = new ThreadLocal<>();

    public static void updateCounter() {
        if (Objects.isNull(counter.get())) {
            counter.set(1);
        } else {
            counter.set(counter.get() + 1);
        }
    }

    public static void resetCounter() {
        counter.set(0);
    }

    public static Integer getCounter() {
        return counter.get();
    }
}