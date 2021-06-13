package com.threads;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Inside new thread - " + Thread.currentThread().getName());
            }
        });
        thread.setName("Test Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("In thread before: " + Thread.currentThread().getName());
        thread.start();
        System.out.println("In thread after: " + Thread.currentThread().getName());

//        Thread.sleep(10000);
    }
}
