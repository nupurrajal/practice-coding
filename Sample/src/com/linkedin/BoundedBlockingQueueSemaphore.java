package com.linkedin;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBlockingQueueSemaphore {
    /*
    Semaphore: A synchronization aid to control the number of threads accessing a resource (or slots in the queue).
    ReentrantLock: Provides mutual exclusion, ensuring only one thread modifies the queue at a time.
    emptySlots: A semaphore initialized with capacity. It tracks the number of available slots in the queue. Each producer thread acquires a permit before adding an item and releases it after removing one.
    filledSlots: A semaphore initialized with 0. It tracks the number of elements in the queue. Each consumer thread acquires a permit before removing an item and releases it after adding one.
    lock: Ensures mutual exclusion while modifying the queue. Unlike a semaphore, it’s not a counter but a binary mechanism to protect critical sections.
     */
    private final int capacity;
    private final Deque<Integer> queue;
    private final Semaphore emptySlots; // Tracks empty slots
    private final Semaphore filledSlots; // Tracks filled slots
    private final ReentrantLock lock; // Mutex for accessing the queue

    /*
    emptySlots: Starts with capacity, meaning all slots are available for producers initially.
    filledSlots: Starts with 0, meaning no items are available for consumption.
    Critical Multithreading Concept: The combination of Semaphore and ReentrantLock ensures:
    Producers block when the queue is full (emptySlots permits exhausted).
    Consumers block when the queue is empty (filledSlots permits exhausted).
    Only one thread modifies the queue at a time (via lock).
     */
    public BoundedBlockingQueueSemaphore(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
        this.emptySlots = new Semaphore(this.capacity); // Initially, all slots are empty
        this.filledSlots = new Semaphore(0); // Initially, no items are available
        this.lock = new ReentrantLock();
    }

    public static void main(String[] args) {
        BoundedBlockingQueueSemaphore blockingQueue = new BoundedBlockingQueueSemaphore(5);
        /*
        Continuously produces items and attempts to add them to the queue using enque.
        Blocks when the queue is full (due to emptySlots.acquire()).
         */
        Runnable producer = () -> {
          try {
              for (int i = 1; i <= 10; i++) {
                  System.out.println(Thread.currentThread().getName() + " producing: " + i);
                  blockingQueue.enque(i);
                  Thread.sleep(500);
              }
          } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
          }
        };
        /*
        Continuously consumes items from the queue using dequeue.
        Blocks when the queue is empty (due to filledSlots.acquire()).
         */
        Runnable consumer = () -> {
          try {
              for (int i = 1; i <= 10; i++) {
                  int item = blockingQueue.dequeue();
                  System.out.println(Thread.currentThread().getName() + " consuming: " + item);
                  Thread.sleep(1000);
              }
          } catch (InterruptedException ex) {
              Thread.currentThread().interrupt();
          }
        };
        Thread producerThread = new Thread(producer, "producer");
        Thread consumerThread = new Thread(consumer, "consumer");

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    /*
    Semaphore Acquire: If emptySlots is 0 (queue is full), the producer thread blocks here until a consumer releases a permit.
    This ensures that producers respect the capacity limit.

    ReentrantLock: Ensures only one thread at a time can modify the queue, preventing race conditions.
    The element is safely added to the queue, and the lock is released regardless of success or failure, preventing deadlocks.
    Semaphore Release: Increments the filledSlots, signaling a waiting consumer (if any) that an item is now available.
     */
    public void enque(int element) throws InterruptedException {
        emptySlots.acquire();
        lock.lock();
        try {
            queue.addLast(element);
        } finally {
            lock.unlock();
        }
        filledSlots.release();
    }

    /*
    Semaphore Acquire: If filledSlots is 0 (queue is empty), the consumer thread blocks here until a producer releases a permit.
    The element is removed safely. finally ensures the lock is released even in case of an exception.
    Semaphore Release: Increments emptySlots, signaling a waiting producer (if any) that space is now available in the queue.
     */
    public int dequeue() throws InterruptedException {
        filledSlots.acquire();
        int result;
        lock.lock();
        try {
            result = queue.removeFirst();
        } finally {
            lock.unlock();
        }
        emptySlots.release();
        return result;
    }

    public int size() {
        lock.lock();
        try {
            return queue.size();
        } finally {
            lock.unlock();
        }
    }
}
