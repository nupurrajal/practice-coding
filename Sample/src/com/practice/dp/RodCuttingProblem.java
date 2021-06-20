package com.practice.dp;

import java.util.Scanner;

public class RodCuttingProblem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // length of rod
        int[] price = new int[N];
        for (int i  = 0; i < N; i++) {
            price[i] = sc.nextInt();
        }
        System.out.println(maximumProfitByCuttingRod(N, price));
        sc.close();
    }

    private static int maximumProfitByCuttingRod(int N, int[] price) {
        // dp dimension would be n+1 and length+1 as length might be restricted too
        int[] length = new int[N];
        for (int i = 0; i < N; i++) {
            length[i] = i+1;
        }
        int[][] dp = new int[N+1][length.length+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= length.length; j++) {
                if (length[i-1] <= j) {
                    dp[i][j] = Math.max(price[i-1] + dp[i][j-length[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[N][length.length];
    }
}

/*
8
1 5 8 9 10 17 17 20
 */
