package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        sum = Arrays.stream(array).sum() / 2;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (Boolean[] arr : dp) {
            Arrays.fill(arr, false);
        }
        minimumSubsetSumProblemDP(array, sum, n, dp);
        int i;
        for (i = sum; i >=0; i--) {
            if (dp[n][i] == true) {
                break;
            }
        }
        System.out.println(Arrays.stream(array).sum() - 2*i);
    }

    private static void minimumSubsetSumProblemDP(int[] array, int sum, int n, Boolean[][] dp) {
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (array[i-1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i-1][j - array[i-1]];
                }
            }
        }
    }
}

/*
3
1 2 7
 */