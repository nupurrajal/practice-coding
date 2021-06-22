package com.practice.dp;

import java.util.Scanner;

public class MinimumDeletionInStringForPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(minimumDeletionsToMakePalindromeBottomUp(s1, s1.length(), new StringBuilder(s1).reverse().toString(), s1.length()));
        sc.close();
    }

    private static int minimumDeletionsToMakePalindromeBottomUp(String s1, int len1, String s2, int len2) {
        int longestPalindromicLength = LongestCommonSubsequence.findLongestCommonSubsequenceBottomUp(s1, s2, len1, len2);
        return len1 - longestPalindromicLength;
    }
}
