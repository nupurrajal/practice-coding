package com.practice.dp;

import java.util.Scanner;

public class CountSubsetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(countSubsetSumDP(array, sum, n));
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
    }

    private static int countSubsetSumRecursion(int[] array, int sum, int n) {
        if (sum == 0) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (array[n-1] > sum) {
            return countSubsetSumRecursion(array, sum, n-1);
        }
        return countSubsetSumRecursion(array, sum, n-1) + countSubsetSumRecursion(array, sum - array[n-1], n-1);
    }

    private static int countSubsetSumDP(int[] array, int sum, int n) {
        int[][] dp = new int[n+1][sum+1];
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (array[i-1] <= j) {
                    dp[i][j] += dp[i-1][j-array[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}

/*
6 10
2 3 5 6 8 10
 */