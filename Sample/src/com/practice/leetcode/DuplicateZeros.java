package com.practice.leetcode;

import java.util.Scanner;

public class DuplicateZeros {

    private static void duplicateZeroAdd(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int prev = 0;
                for (int j = i+1; j < arr.length; j++) {
                    int curr = arr[j];
                    arr[j] = prev;
                    prev = curr;
                }
                i++;
            }
        }
        for (int i : arr)
            System.out.print(i + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        duplicateZeroAdd(A);
    }
}
