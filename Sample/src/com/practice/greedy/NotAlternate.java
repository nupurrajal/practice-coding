package com.practice.greedy;

import java.util.Scanner;

public class NotAlternate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i ++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(maxDiamondsToCollect(n, arr));
        sc.close();
    }

    private static int maxDiamondsToCollect(int n, int[] arr) {
        if (n <= 0) {
            return 0;
        }
        return Math.max(arr[n-1] + maxDiamondsToCollect(n-2, arr), maxDiamondsToCollect(n-1, arr));
    }

    private static int maxDiamondsToCollectDP(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }
        int[] dp = new int[n];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(arr[i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }
}
/*
5
1 2 3 4 5
 */