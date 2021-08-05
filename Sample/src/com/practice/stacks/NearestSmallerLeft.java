package com.practice.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class NearestSmallerLeft {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int res : findNextSmallerLeft(n, arr)) {
            System.out.print(res + " ");
        }
        sc.close();
    }

    private static List<Integer> findNextSmallerLeft(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> resL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                resL.add(-1);
            } else if (stack.peek() >= arr[i]) {
                while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    resL.add(-1);
                } else {
                    resL.add(stack.peek());
                }
            } else if (stack.peek() < arr[i]) {
                resL.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return resL;
    }
}

/*
4
1 3 2 4

5
4 5 2 10 8
 */
