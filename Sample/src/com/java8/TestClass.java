package com.java8;

public class TestClass implements TestInterface1, TestInterface2 {


    @Override
    public void show() {

    }

    public static void main(String[] args) {
        System.out.println(TestInterface2.i1);
        TestInterface1.teststatic();
    }
}
