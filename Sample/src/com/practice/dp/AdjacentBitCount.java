package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class AdjacentBitCount {

    static int[][][] dp;

    static {
        dp = new int[101][101][2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int turn = sc.nextInt();
            int n = sc.nextInt();
            int k = sc.nextInt();
            for (int[][] row : dp) {
                for (int[] row1 : row)
                    Arrays.fill(row1, -1);
            }
            int res = countAdjacentBitsDP(n, k, 0);
            res += countAdjacentBitsDP(n, k, 1);
            System.out.println(turn + " " + res);
        }
    }

    private static int countAdjacentBitsRecursive(int n, int k, int first) {
        if (n == 0)
            return 0;
        if (n == 1) {
            if (k == 0)
                return 1;
            else
                return 0;
        }
        int result;
        if (first == 1) {
            result = countAdjacentBitsRecursive(n-1, k-1, 1) + countAdjacentBitsRecursive(n-1, k, 0);
        } else {
            result = countAdjacentBitsRecursive(n-1, k, 1) + countAdjacentBitsRecursive(n-1, k, 0);
        }
        return result;
    }

    private static int countAdjacentBitsDP(int n, int k, int first) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            if (k == 0)
                return 1;
            else
                return 0;
        }
        if (dp[n][k][first] != -1)
            return dp[n][k][first];
        int result;
        if (first == 1) {
            result = countAdjacentBitsDP(n-1,k-1,1) + countAdjacentBitsDP(n-1, k, 0);
        } else {
            result = countAdjacentBitsDP(n-1, k, 1) + countAdjacentBitsDP(n-1, k, 0);
        }
        return dp[n][k][first] = result;
    }
}

/*
2
1 5 2
2 20 8
 */