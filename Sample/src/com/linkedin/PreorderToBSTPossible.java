package com.linkedin;

import java.util.Scanner;
import java.util.Stack;

public class PreorderToBSTPossible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(canRepresentBST(arr, n));
        System.out.println(canRepresentBSTStack(arr));
    }

    static int canRepresentBST(int arr[], int N) {
        // code here
        boolean res = canRepresentBST(arr, 0, N-1);
        return res ? 1 : 0;
    }

    static boolean canRepresentBST(int arr[], int start, int end) {
        // code here
        if (start > end) {
            return true;
        }
        int root = arr[start];
        int left = start + 1;
        while (left <= end && arr[left] < root) {
            left++;
        }
        for (int i = left; i <= end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return canRepresentBST(arr, start+1, left-1) && canRepresentBST(arr, left, end);
    }

    private static boolean canRepresentBSTStack(int[] arr) {
        int root = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (i < root) {
                return false;
            }
            while (!stack.isEmpty() && stack.peek() < i) {
                root = stack.pop();
            }
            stack.push(i);
        }
        return true;
    }
}

/*
3
2 4 3
5
40 30 35 80 100
should be 1
 */