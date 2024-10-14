package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromePartitioning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
//        System.out.println(palindromePartitionCountRecursive(s, 0, s.length()-1));

        int[][] dp = new int[s.length()+1][s.length()+1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
//        long start = System.currentTimeMillis();
        System.out.println(palindromePartitionCountTopDown(s, 0, s.length()-1, dp));
//        System.out.println(System.currentTimeMillis()-start);
        sc.close();
    }

    private static int palindromePartitionCountRecursive(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, 1 + palindromePartitionCountRecursive(s, i, k)+ palindromePartitionCountRecursive(s, k+1, j));
        }
        return min;
    }

    private static int palindromePartitionCountTopDown(String s, int i, int j, int[][] dp) {
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(s, i, j)) {
            return dp[i][j] = 0;
        }
        if (dp[i][j] != -1) {

            return dp[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            min = Math.min(min, 1 + palindromePartitionCountTopDown(s, i, k, dp)+ palindromePartitionCountTopDown(s, k+1, j, dp));
        }
        return dp[i][j] = min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

/*
litil
ababbbabbababa
 */