package com.practice.stacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class MaxHistogram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxHistogramWay2(arr));
        sc.close();
    }

    private static int maxHistogramWay2 (int[] arr) {
        Stack<Integer> pStack = new Stack<>();
        Stack<Integer> hStack = new Stack<>();
        int maxArea = 0, len = arr.length;
        for (int i = 0; i < len; i++) {
            int lastWidth = Integer.MAX_VALUE;
            while (!hStack.isEmpty() && hStack.peek() > arr[i]) {
                lastWidth = pStack.peek();
                int width = i - pStack.pop();
                int height = hStack.pop();
                maxArea = Math.max(maxArea, width * height);
            }
            if (hStack.isEmpty() || hStack.peek() < arr[i]) {
                hStack.push(arr[i]);
                pStack.push(Math.min(lastWidth,i));
            }
        }
        return maxArea;
    }

    public static int maxHistogram(int input[]){
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peekFirst()] <= input[i]){
                stack.offerFirst(i++);
            }else{
                int top = stack.pollFirst();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peekFirst() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pollFirst();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peekFirst() - 1);
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }
}

/*
6
2 1 5 6 2 3
 */
