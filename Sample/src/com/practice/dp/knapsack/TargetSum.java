package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

// https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12&ab_channel=AdityaVerma

public class TargetSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int sum = Arrays.stream(arr).sum();
        if (sum < target) {
            System.out.println("Not possible");
            System.exit(0);
        }
        int toCheck = sum + target;
        if (toCheck %2 != 0) {
            System.out.println("Not possible");
            System.exit(0);
        }

        // basically find 2 partitions
        // s1 and s2
        // so that abs diff is given
        // s1 + s2 = sum
        // s2 - s1 = given
        // s2 = (sum + given) / 2
        // sp sum + given should be even
        toCheck = toCheck / 2;
        Integer[][] dp = new Integer[n+1][toCheck+1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        // count of sets where the eventual - / + will get to the target sum
        System.out.println(getTargetSumMemoization(n, toCheck, arr, dp));
        sc.close();
    }

    private static int getTargetSumMemoization(int n, int target, int[] arr, Integer[][] dp) {
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }
        if (arr[n-1] <= target) {
            return dp[n][target] = getTargetSumMemoization(n-1, target, arr, dp) + getTargetSumMemoization(n-1, target - arr[n-1], arr, dp);
        }
        return dp[n][target] = getTargetSumMemoization(n-1, target, arr, dp);
    }
}

/*
4 1
1 1 2 3
 */