package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] weight = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][W + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(knapsackTopDown(n, W, weight, value));
    }

    private static int knapsackMemoization(int n, int W, int[] weight, int[] value, int[][] dp) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (weight[n-1] > W) {
            return dp[n][W] = knapsackMemoization(n-1, W, weight, value, dp);
        }
        return dp[n][W] = Math.max(value[n-1] + knapsackMemoization(n-1, W-weight[n-1], weight, value, dp), knapsackMemoization(n-1, W, weight, value, dp));
    }

    private static int knapsackRecursion(int n, int W, int[] weight, int[] value) {
        if (n == 0 || W == 0) {
            return 0;
        }
        if (weight[n-1] > W) {
            return knapsackRecursion(n-1, W, weight, value);
        }
        return Math.max(value[n-1] + knapsackRecursion(n-1, W-weight[n-1], weight, value), knapsackRecursion(n-1, W, weight, value));
    }

    private static int knapsackTopDown(int n, int W, int[] weight, int[] value) {
        int[][] dp = new int[n+1][W+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (weight[i-1] <= j) {
                    dp[i][j] = Math.max(value[i-1] + dp[i-1][j-weight[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][W];
    }
}

/*
3
50
10 20 30
60 100 200

4
7
1 3 4 5
1 4 5 7
 */