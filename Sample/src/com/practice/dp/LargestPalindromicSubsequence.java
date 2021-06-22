package com.practice.dp;

import java.util.Scanner;

public class LargestPalindromicSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(longestPalindromicTopDown(s1, s1.length(), new StringBuilder(s1).reverse().toString(), s1.length()));
        sc.close();
    }

    public static int longestPalindromicTopDown(String s1, int len1, String s2, int len2) {
        return LongestCommonSubsequence.findLongestCommonSubsequenceBottomUp(s1, s2, len1, len2);
    }
}

/*
agbcba
 */