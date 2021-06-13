package com.java8;

interface A {
    void show();
}

public class LambdaSample {

    public static void main(String[] args) {
        A obj = new A() {
            @Override
            public void show() {

            }
        };
    }
}
