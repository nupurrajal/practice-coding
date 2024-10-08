package com.practice.dp;

import java.util.Scanner;

public class UnboundedKnapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        System.out.println(unboundedKnapsackRecursion(value, n, W, weight));
        sc.close();
    }

    private static int unboundedKnapsackRecursion(int[] value, int n, int W, int[] weight) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (weight[n-1] > W) {
            return unboundedKnapsackRecursion(value, n-1, W, weight);
        }
        return Math.max(unboundedKnapsackRecursion(value, n-1, W, weight), value[n-1] + unboundedKnapsackRecursion(value, n, W - weight[n-1], weight));
    }

    private static int unboundedKnapsackBottomUp (int[] value, int n, int W, int[] weight) {
        int[][] dp = new int[n + 1][W + 1];

        if (n == 0 || W == 0) {
            return 0;
        }
        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < W+1; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i-1] + dp[i][j - weight[i-1]], dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }
}

/*
2 100
1 30
1 50


4 8
10 40 50 70
1 3 4 5
 */