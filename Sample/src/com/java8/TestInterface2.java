package com.java8;

public interface TestInterface2 {
    static int i1 = 1;

    default void show() {
        System.out.println("In 2");
    }
}
