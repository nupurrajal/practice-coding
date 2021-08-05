package com.practice.stacks;

import java.util.*;

public class NextGreaterRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int res : findNextGreater(n, arr)) {
            System.out.print(res + " ");
        }
        sc.close();
    }

    private static List<Integer> findNextGreater(int n, int[] arr) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> resL = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            if (stack.isEmpty()) {
                resL.add(-1);
            } else if (stack.peek() <= arr[i]) {
                while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    resL.add(-1);
                } else {
                    resL.add(stack.peek());
                }
            } else {
                resL.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        Collections.reverse(resL);
        return resL;
    }
}

/*
7
1 3 0 0 1 2 4
 */