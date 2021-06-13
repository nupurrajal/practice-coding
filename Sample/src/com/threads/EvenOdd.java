package com.threads;

public class EvenOdd {

    public static void main(String[] args) throws InterruptedException {
        int i = 10;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               for (int ind = 0; ind <= i; ind+=2)  {
                   System.out.println(ind + ": " + Thread.currentThread().getName());
               }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int ind = 1; ind <= i; ind+=2)  {
                    System.out.println(ind + ": " + Thread.currentThread().getName());
                }
            }
        });

        t1.start();
        t2.start();
    }
}
