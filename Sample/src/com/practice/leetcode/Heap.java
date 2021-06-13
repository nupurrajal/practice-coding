package com.practice.leetcode;

public class Heap {

    int[] arr;
    int capacity;
    int currSize;

    int parent(int i) { return (i-1) / 2;}
    int leftChild(int i) { return (2 * i) + 1;}
    int rightChild(int i) { return (2 * i) + 2;}

    void insertKey(int key) {
        if (currSize == capacity) {
            System.out.println("Overflow");
            return;
        }
        int index = currSize;
        currSize++;
        arr[index] = key;
        while (index != 0 && arr[parent(index)] > arr[index]) {
            int pIndex = parent(index);
            int temp = arr[pIndex];
            arr[pIndex] = arr[index];
            arr[index] = arr[pIndex];
            index = pIndex;
        }
    }

}
