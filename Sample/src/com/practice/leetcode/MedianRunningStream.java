package com.practice.leetcode;

import java.util.*;

public class MedianRunningStream {
    public static void main(String[] args) {
        MedianFinderHeap medianFinder = new MedianFinderHeap();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    /** initialize your data structure here. */
    private List<Integer> inputStream;
    private int medianIndex;

    public MedianFinder() {
        inputStream = new ArrayList();
        medianIndex = -1;
    }

    public void addNum(int num) {
        inputStream.add(num);
        if (inputStream.size() % 2 == 1) {
            medianIndex++;
        }
    }

    public double findMedian() {
        if (inputStream.size() % 2 == 1) {
            return Double.valueOf(inputStream.get(medianIndex));
        }
        int a = inputStream.get(medianIndex), b = inputStream.get(medianIndex+1);
        return Double.valueOf((a + b)) / 2;
    }
}

class MedianFinderHeap {

    /** initialize your data structure here. */
    PriorityQueue<Integer> bigNums = new PriorityQueue<>();
    PriorityQueue<Integer> smallNums = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinderHeap() {

    }

    public void addNum(int num) {
        bigNums.offer(num);
        smallNums.offer(bigNums.poll());
        if (smallNums.size() > bigNums.size()) {
            bigNums.offer(smallNums.poll());
        }
    }

    public double findMedian() {
        if (bigNums.size() == smallNums.size()) {
            return Double.valueOf(bigNums.peek() + smallNums.peek()) / 2;
        }
        return bigNums.peek();
    }
}