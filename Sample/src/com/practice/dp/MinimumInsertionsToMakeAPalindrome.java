package com.practice.dp;

import java.util.Scanner;

public class MinimumInsertionsToMakeAPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        System.out.println(minimumNumberOfDeletionsInS(s1, s1.length()));
        sc.close();
    }

    private static int minimumNumberOfDeletionsInS(String s1, int len1) {
        String ss1 = s1.substring(0, len1/2);

        String ss2;
        if (len1 % 2 == 0)
            ss2 = s1.substring(len1/2);
        else {
            ss2 = s1.substring((len1/2) + 1);
        }
        System.out.println(ss1);
        System.out.println(ss2);
        int len2 = len1;
        int lcs = LargestPalindromicSubsequence.longestPalindromicTopDown(ss1, len1/2, new StringBuilder(ss2).reverse().toString(), len2/2);
        int ans = len1 - 2*lcs;
        if (len1%2 == 1) {
            ans -= 1;
        }
        return ans;
    }
}
/*
acbcbda
acbcdbda
 */
