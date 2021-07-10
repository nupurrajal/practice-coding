package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class EggDroppingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int eggs = sc.nextInt();
        int floors = sc.nextInt();
//        System.out.println(printMinimumEggsRequiredToVerify(eggs, floors));
        int[][] dp = new int[eggs+1][floors+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        System.out.println(printMinimumEggsRequiredToVerifyMemoization(eggs, floors, dp));
        sc.close();
    }

    private static int printMinimumEggsRequiredToVerify(int eggs, int floors) {
        if (eggs <= 0) {
            return 0;
        }
        if (floors <= 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }
        int min = Integer.MAX_VALUE-1;
        for (int k = 1; k <= floors; k++) {
            min = Math.min(min, 1 + Math.max(printMinimumEggsRequiredToVerify(eggs-1, k-1), printMinimumEggsRequiredToVerify(eggs, floors-k)));
        }
        return min;
    }

    private static int printMinimumEggsRequiredToVerifyMemoization(int eggs, int floors, int[][] dp) {
        if (eggs <= 0) {
            return 0;
        }
        if (floors <= 1) {
            return floors;
        }
        if (eggs == 1) {
            return floors;
        }
        if (dp[eggs][floors] != -1)
            return dp[eggs][floors];
        int min = Integer.MAX_VALUE-1;
        for (int k = 1; k <= floors; k++) {
            min = Math.min(min, 1 + Math.max(printMinimumEggsRequiredToVerifyMemoization(eggs-1, k-1, dp), printMinimumEggsRequiredToVerifyMemoization(eggs, floors-k, dp)));
        }
        return dp[eggs][floors] = min;
    }
}

/*
3
5
 */