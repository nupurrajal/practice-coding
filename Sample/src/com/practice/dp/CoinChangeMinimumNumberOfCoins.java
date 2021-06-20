package com.practice.dp;

import java.util.Scanner;

public class CoinChangeMinimumNumberOfCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        System.out.println(printMinNumberOfCoins(n, sum, coins));
        sc.close();
    }

    private static int printMinNumberOfCoins(int n, int sum, int[] coins) {
        int[][] dp = new int[n+1][sum+1];
//        for (int i = 0; i <= n; i++) {
//            dp[i][0] = 1;
//        }
        for (int i = 0; i <= sum; i++) {
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i-1] <= j) {
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
/*
3 5
1 2 3
 */