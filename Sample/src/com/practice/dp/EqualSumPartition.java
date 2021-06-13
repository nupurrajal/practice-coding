package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSumPartition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int sum = Arrays.stream(array).sum();
        if (sum % 2 != 0) {
            System.out.println("Not possible");
            System.exit(0);
        } else {
           System.out.println(equalSumPartition(array, sum/2, n));
        }
    }

    private static boolean equalSumPartition(int[] array, int sum, int n) {
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (int j = 0; j <= sum; j++) {
            dp[0][j] = false;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i-1][j];
                if (array[i-1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - array[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}

/*
4
1 5 11 5

Notes:  only even sum would be able to get divided into two equal sums.
        now we need to find only one subset of sum/2 (remaining would be sum/2 only).
 */