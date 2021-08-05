package com.practice.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class StockSpanProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int res : findStockSpan(n, arr)) {
            System.out.print(res + " ");
        }
        sc.close();
    }

    private static List<Integer> findStockSpan(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> resL = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                resL.add(-1);
            } else if (stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    resL.add(-1);
                } else {
                    resL.add(i - stack.peek());
                }
            } else {
                resL.add(stack.peek());
            }
            stack.push(i);
        }
        return resL;
    }
}

/*
7
100 80 60 70 60 75 85
 */