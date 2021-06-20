package com.practice.leetcode;

import java.util.Scanner;

public class Heap {

    int[] arr;
    int size;
    int currSize;

    Heap(int size) {
        this.arr = new int[size];
        this.size = size;
        this.currSize = 0;
    }

    int parent(int i) { return (i-1) / 2;}
    int leftChild(int i) { return (2 * i) + 1;}
    int rightChild(int i) { return (2 * i) + 2;}

    void insertKey(int key) {

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

    void add(int num) {
        if (currSize == size) {
            return;
        }
        int i = currSize;
        arr[currSize++] = num;
        while (i > 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[parent(i)];
            arr[parent(i)] = arr[i];
            arr[i] = temp;
            i = parent(i);
        }
    }



    int getMin () {
        return arr[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Heap heap = new Heap(n);
        for (int i = 0; i < n; i++) {
            heap.add(sc.nextInt());
        }
        System.out.println(heap.size);
        for (int i = 0; i < n; i++) {
            System.out.print(heap.arr[i] + " ");
        }
        System.out.println("something");
    }

}
/*
5
7 10 4 20 15
 */