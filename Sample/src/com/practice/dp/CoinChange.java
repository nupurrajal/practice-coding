/*
All ways to add up to the change
 */

package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int total = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][total + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
//        System.out.println(countWaysToChange(n - 1, total, coins));
        System.out.println(countWaysToChangeDP(n - 1, total, coins, dp));

        sc.close();
    }

    static int countWaysToChange(int n, int total, int[] coins) {
        if (total == 0)
            return 1;
        if (n < 0 || total < 0) {
            return 0;
        }
        return countWaysToChange(n, total - coins[n], coins) + countWaysToChange(n - 1, total, coins);
    }

    static int countWaysToChangeDP(int n, int total, int[] coins, int[][] dp) {
        if (total == 0)
            return 1;
        if (n < 0 || total < 0) {
            return 0;
        }
        if (dp[n][total] != -1) {
            return dp[n][total];
        }
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= total; j++) {
//                dp[i][j] = countWaysToChangeDP()
//            }
//        }
        return dp[n][total] = countWaysToChangeDP(n, total - coins[n], coins, dp) + countWaysToChangeDP(n - 1, total, coins, dp);
//        return countWaysToChange(n, total - coins[n], coins) + countWaysToChange(n - 1, total, coins);
    }
}
