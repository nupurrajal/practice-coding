package com.java8;

public interface TestInterface1 {
    static int i1 = 1;
    default void show() {
        System.out.println("In 1");
    }

//    default boolean equals (Object o) {
//
//    }

    static void teststatic() {
        System.out.println("In teststatic");
    }
}
