package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        // range will be between for s1 s2 0 to total sum

        int sum = Arrays.stream(array).sum() / 2;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        minimumSubsetSumProblemDP(array, sum, n, dp);

        // s1 - s2 = min
        // s2 = range - s1
        // s1 - s2 -> 2s1 - range (total sum)
        // or range - 2s1 -> minimum value
        // min value will come with max s1 on the lower half
        int i;
        for (i = sum; i >=0; i--) {
            if (dp[n][i]) {
                break;
            }
        }
        System.out.println(Arrays.stream(array).sum() - 2*i);
    }

    private static void minimumSubsetSumProblemDP(int[] array, int sum, int n, Boolean[][] dp) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (array[i-1] <= j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-array[i-1]];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
    }
}

/*
3
1 2 7
 */