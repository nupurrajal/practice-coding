package com.practice.leetcode;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class LRUCache {
    LinkedHashMap<Integer, Integer> lruCache;
    int capacity;
    public LRUCache(int capacity) {
        lruCache = new LinkedHashMap();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (lruCache.containsKey(key)) {
            int value = lruCache.get(key);
            lruCache.remove(key);
            lruCache.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            lruCache.remove(key);
            lruCache.put(key, value);
        } else {
            if (lruCache.size() == capacity) {
                System.out.println("Removed: " + lruCache.entrySet().iterator().next().getKey());
                lruCache.remove((Integer) lruCache.entrySet().iterator().next().getKey());
            }
            lruCache.put(key, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        sc.close();
    }
}
