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
        System.out.println(countWaysToChangeDP(n - 1, total, coins, dp));
        sc.close();
    }

    private static int countWaysToChangeDP(int n, int total, int[] coins, int[][] dp) {

        return 0;
    }
}
