package com.practice.dp;

import java.util.Scanner;

public class SequencePatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next(), s2 = sc.next();
        System.out.println(checkIfAIsSubsequenceOfB(s1, s1.length(), s2, s2.length()));
        sc.close();
    }

    private static boolean checkIfAIsSubsequenceOfB(String s1, int len1, String s2, int len2) {
        int[][] dp = new int[len1+1][len2+1];
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
//        int i = len1, j = len2;
//        while (i > 0 && j > 0) {
//            if (s1.charAt(i-1) == s2.charAt(j-1)) {
//                result.append(s1.charAt(i-1));
//                i--;
//                j--;
//            } else {
//                if (dp[i-1][j] > dp[i][j-1]) {
//                    i--;
//                } else {
//                    j--;
//                }
//            }
//        }
//        return s1.equals(result.reverse().toString());
        return len1==dp[len1][len2];
    }

    private static boolean checkIfAIsSubsequenceOfB(String s, String t) {
        int count = 0;
        int l1 = s.length();
        int l2 = t.length();
        int i = 0, j = 0;
        while (i < l1 && j < l2) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                count++;
            } else {
                j++;
            }
        }
        return count==l1;
    }
}

/*
axy
adxcpy
 */