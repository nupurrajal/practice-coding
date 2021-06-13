package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class EqualAveragePartition {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        Integer i = 1;
        System.out.println(equalAveragePartition(array, n));
    }

    private static boolean equalAveragePartition(int[] array, int n) {
        int sum = Arrays.stream(array).sum();
        if (sum % n != 0) {
            return false;
        }
        int average = sum / n;
        int[][] dp = new int[n + 1][sum + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (array[i - 1] <= j) {
                    dp[i][j] = dp[i][j] + dp[i - 1][j - array[i - 1]];
                }
            }
        }
        return dp[n][sum] == average;
    }
}
