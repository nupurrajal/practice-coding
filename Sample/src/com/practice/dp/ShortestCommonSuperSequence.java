package com.practice.dp;

import java.util.Scanner;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(shortestSuperSubsequence(s1, s2, s1.length(), s2.length()));
        sc.close();
    }

    private static int shortestSuperSubsequence(String s1, String s2, int len1, int len2) {
        return len1 + len2 - LongestCommonSubsequence.findLongestCommonSubsequenceBottomUp(s1, s2, len1, len2);
    }
}
