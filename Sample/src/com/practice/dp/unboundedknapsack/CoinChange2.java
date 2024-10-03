/*

 */

package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CoinChange2 {

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
        System.out.println(countWaysToChangeRecursion(n - 1, total, coins));
        sc.close();
    }

    private static int countWaysToChangeRecursion(int n, int total, int[] coins) {
        // Base case: If the total becomes zero, no more coins are needed
        if (total == 0) {
            return 0;  // 0 coins are needed if the total is exactly 0
        }
        // If no coins are left but total is still positive, return a large number to indicate no solution
        if (n == 0) {
            return Integer.MAX_VALUE - 1; // Return a large value, but avoid overflow when adding 1
        }
        // If the current coin is greater than the total, skip this coin
        if (coins[n-1] > total) {
            return countWaysToChangeRecursion(n-1, total, coins);
        }

        // Recurrence: find the minimum between excluding and including the current coin
        int excludeCoin = countWaysToChangeRecursion(n-1, total, coins);  // Exclude current coin
        int includeCoin = countWaysToChangeRecursion(n, total-coins[n-1], coins); // Include current coin

        // Add 1 to includeCoin only if it's a valid solution (not Integer.MAX_VALUE - 1)
        if (includeCoin != Integer.MAX_VALUE - 1) {
            includeCoin += 1; // Only add 1 if we didn't hit the MAX_VALUE case (i.e., a valid solution)
        }

        return Math.min(excludeCoin, includeCoin);
    }

    private static int countWaysToChangeDP(int n, int total, int[] coins, int[][] dp) {

        return 0;
    }
}

/*
3 5
1 2 5
 */
