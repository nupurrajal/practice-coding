package com.practice.dp;

import java.util.Scanner;

public class LongestCommonSubstring {
    static int res = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(findLongestCommonSubstringRecursive(s1, s2, s1.length(), s2.length(), 0));

//        int[][] dp = new int[s1.length()+1][s2.length()+1];
//        for (int[] arr : dp) {
//            Arrays.fill(arr, -1);
//        }
//        System.out.println(findLongestCommonSubstringMemoization(s1, s2, s1.length(), s2.length(), dp));

//        System.out.println(findLongestCommonSubstringBottomUp(s1, s2, s1.length(), s2.length()));

        sc.close();
    }

    private static int findLongestCommonSubstringRecursive(String s1, String s2, int len1, int len2, int count) {
        if (len1 == 0 || len2 == 0) {
            return res = Math.max(count, res);
        }
        if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return findLongestCommonSubstringRecursive(s1, s2, len1-1, len2-1, count+1);
        }
        return Math.max(findLongestCommonSubstringRecursive(s1, s2, len1-1, len2, 0), findLongestCommonSubstringRecursive(s1, s2, len1, len2-1, count));
    }

    private static int findLongestCommonSubstringMemoization(String s1, String s2, int len1, int len2, int[][] dp) {
        // incorrect implementation as of now.
        if (len1 == 0 || len2 == 0) {
            return 0;
        }
        if (dp[len1][len2] != -1) {
            return dp[len1][len2];
        }
        if (s1.charAt(len1-1) == s2.charAt(len2-1)) {
            return dp[len1][len2] = 1 + findLongestCommonSubstringMemoization(s1, s2, len1-1, len2-1, dp);
        }
        return dp[len1][len2] = Math.max(findLongestCommonSubstringMemoization(s1, s2, len1-1, len2, dp), findLongestCommonSubstringMemoization(s1, s2, len1, len2-1, dp));
    }

    private static int findLongestCommonSubstringBottomUp(String s1, String s2, int len1, int len2) {
        int[][] dp = new int[len1+1][len2+1];
        int res = 0;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}
/*
abcdgh
abedfhr
 */