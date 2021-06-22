package com.practice.dp;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
//        System.out.println(findLongestCommonSubsequenceRecursive(s1, s2, s1.length(), s2.length()));

//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(findLongestCommonSubsequenceMemoization(s1, s2, s1.length(), s2.length(), dp));

        System.out.println(findLongestCommonSubsequenceBottomUp(s1, s2, s1.length(), s2.length()));

        sc.close();
    }

    private static int findLongestCommonSubsequenceRecursive(String s1, String s2, int len1, int len2) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return 1 + findLongestCommonSubsequenceRecursive(s1, s2, len1-1, len2-1);
        }
        return Math.max(findLongestCommonSubsequenceRecursive(s1, s2, len1-1, len2), findLongestCommonSubsequenceRecursive(s1, s2, len1, len2-1));
    }

    private static int findLongestCommonSubsequenceMemoization(String s1, String s2, int len1, int len2, int[][] dp) {
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (dp[len1][len2] != -1) {
            return dp[len1][len2];
        }
        if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return dp[len1][len2] = 1 + findLongestCommonSubsequenceMemoization(s1, s2, len1-1, len2-1, dp);
        }
        return dp[len1][len2] = Math.max(findLongestCommonSubsequenceMemoization(s1, s2, len1-1, len2, dp), findLongestCommonSubsequenceMemoization(s1, s2, len1, len2-1, dp));
    }

    public static int findLongestCommonSubsequenceBottomUp(String s1, String s2, int len1, int len2) {
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
        return dp[len1][len2];
    }

}

/*
abcdgh
abedfhr
 */