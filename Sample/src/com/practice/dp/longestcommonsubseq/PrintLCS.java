package com.practice.dp;

import java.util.Scanner;

public class PrintLCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(printLongestCommonSubsequenceTopDown(s1, s2, s1.length(), s2.length()));
        sc.close();
    }

    public static String printLongestCommonSubsequenceTopDown(String s1, String s2, int len1, int len2) {
        StringBuilder result = new StringBuilder();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        for (int i = 1; i <= len2; i++) {
//            if (dp[len1][i] != dp[len1][i-1]) {
//                result.append(s2.charAt(i-1));
//            }
//        }
        int i = len1, j = len2;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                result.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (dp[i-1][j] > dp[i][j-1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return result.reverse().toString();
    }
}

/*
acbcf
abcdaf
 */