package com.practice.dp;

import java.util.Scanner;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(longestRepeatingSubsequenceLength(s1, s1.length()));
        sc.close();
    }

    private static int longestRepeatingSubsequenceLength(String s1, int len1) {
        String s2 = s1;
        int len2 = len1;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (i != j && s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}

/*
AABEBCDD
 */