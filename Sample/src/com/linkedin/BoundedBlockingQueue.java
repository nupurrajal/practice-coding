package com.linkedin;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/*
The problem requires designing a thread-safe Bounded Blocking Queue. A blocking queue:
Has a fixed maximum capacity.
Supports concurrent enqueue and dequeue operations.
Blocks threads attempting to:
Enqueue if the queue is full.
Dequeue if the queue is empty.
 */

public class BoundedBlockingQueue {
    private final int capacity;
    private final Deque<Integer> queue;
    private final ReentrantLock lock;
    private final Condition notFull;
    private final Condition notEmpty;

    public static void main(String[] args) {
        // Create a bounded blocking queue with a capacity of 5
        BoundedBlockingQueue queue = new BoundedBlockingQueue(5);

        // Create a thread pool for producers and consumers
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Producer task
        Runnable producer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(Thread.currentThread().getName() + " producing: " + i);
                    queue.enqueue(i);
                    Thread.sleep(500); // Simulate some delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Consumer task
        Runnable consumer = () -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    int item = queue.dequeue();
                    System.out.println(Thread.currentThread().getName() + " consuming: " + item);
                    Thread.sleep(1000); // Simulate some delay
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Submit tasks to the executor
        executor.submit(producer);
        executor.submit(consumer);

        // Shut down the executor service after completion
        executor.shutdown();
    }

    public BoundedBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.lock = new ReentrantLock();
        this.notFull = lock.newCondition();
        this.notEmpty = lock.newCondition();
    }

    // Enqueue an element into the queue
    public void enqueue(int element) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await(); // Wait until there is space
            }
            queue.addLast(element);
            notEmpty.signal(); // Signal that the queue is no longer empty
        } finally {
            lock.unlock();
        }
    }

    // Dequeue an element from the queue
    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await(); // Wait until the queue is not empty
            }
            int result = queue.removeFirst();
            notFull.signal(); // Signal that there is now space in the queue
            return result;
        } finally {
            lock.unlock();
        }
    }

    // Get the current size of the queue
    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
