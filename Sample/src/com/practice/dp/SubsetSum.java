package com.practice.dp;

import java.util.Scanner;

public class SubsetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(subsetSumRecursion(array, sum, n));
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
    }

    private static boolean subsetSumRecursion(int[] array, int sum, int n) {
        if (n == 0) {
//            if (sum == 0)
//                return true;
//            else
                return false;
        }
        if (sum == 0)
            return true;
        if (array[n-1] > sum) {
            return subsetSumRecursion(array, sum, n-1);
        }
        return subsetSumRecursion(array, sum - array[n-1], n-1) || subsetSumRecursion(array, sum, n-1);
    }

    private static boolean subsetSumMemoization(int[] array, int sum, int n, Boolean[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (n == 0) {
            return false;
        }
        if (dp[n][sum] != null) {
            return dp[n][sum];
        }
        if (array[n-1] > sum) {
            return dp[n][sum] = subsetSumMemoization(array, sum, n-1, dp);
        }
        return dp[n][sum] = subsetSumMemoization(array, sum - array[n-1], n-1, dp) || subsetSumMemoization(array, sum, n-1, dp);
    }

    private static boolean subsetSumDP(int[] array, int sum, int n) {
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (array[i-1] > j) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}

/*
5 11
2 3 7 8 10
 */