package com.linkedin;

import java.util.Arrays;
import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int[] arr = new int[]{4 , 5 , 2 , 25};
        int n = arr.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        int l = 0;
        stack.add(arr[0]);
        int index = 2*n-1;
        for (int i = index; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i%n]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                res[i%n] = stack.peek();
            }
            stack.push(arr[i%n]);
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
    }


}
