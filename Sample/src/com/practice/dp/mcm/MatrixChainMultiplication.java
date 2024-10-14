package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {
    public static void main(String[] args) {
        // input is arr / string
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(getMinimumCostOfMatrixMultiplication(arr, 1, n-1));

//        int[][] dp = new int[n][n];
//        for (int[] temp : dp) {
//            Arrays.fill(temp, -1);
//        }
//        System.out.println(getMinimumCostOfMatrixMultiplicationBottomUp(arr, 1, n-1, dp));

        System.out.println(getMinimumCostOfMatrixMultiplicationTopDown(arr, n));
        sc.close();
    }

    private static int getMinimumCostOfMatrixMultiplication (int[] arr, int i, int j) {
        if (i >= j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp = getMinimumCostOfMatrixMultiplication(arr, i, k) + getMinimumCostOfMatrixMultiplication(arr, k+1, j) + arr[i-1] * arr[k] * arr[j];
            min = Math.min(min, temp);
        }
        return min;
    }

    private static int getMinimumCostOfMatrixMultiplicationBottomUp (int[] arr, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k <= j-1; k++) {
            int temp = arr[i-1] * arr[k] * arr[j] + getMinimumCostOfMatrixMultiplicationBottomUp(arr, i, k, dp)
                    + getMinimumCostOfMatrixMultiplicationBottomUp(arr, k+1, j, dp);
            dp[i][j] = Math.min(dp[i][j], temp);
        }
        return dp[i][j];
    }

    private static int getMinimumCostOfMatrixMultiplicationTopDown (int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int[] temp : dp) {
            Arrays.fill(temp, Integer.MAX_VALUE-1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = i; k <= j - 1; k++) {
                    int temp = arr[i - 1] * arr[k] * arr[j] + dp[k+1][j] + dp[i][k];
                    dp[i][j] = Math.min(dp[i][j], temp);
                }
            }
        }
        return dp[1][n-1];
    }

    // sample code
    private static int solve (int[] arr, int i, int j) {
        if (i > j) {
            return 0;
        }
        int ans = 0;
        for (int k = i; k <= j; k++) {
            // calculate temporary answer
            int tempAns = solve(arr, i, k) + solve(arr, k+1, j);
            ans = Math.max(tempAns, ans);
        }
        return ans;
    }
}

/*
5
40 20 30 10 30
 */