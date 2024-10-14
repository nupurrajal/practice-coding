package com.practice.dp;

import com.practice.dp.longestcommonsubseq.PrintLCS;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumInsertionDeletionAToB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(Arrays.toString(minimumDeletionS1ToS2(s1, s2, s1.length(), s2.length())));
        sc.close();
    }

    private static int[] minimumDeletionS1ToS2(String s1, String s2, int len1, int len2) {
        int[] result = new int[2];
        String lcs = PrintLCS.printLongestCommonSubsequenceTopDown(s1, s2, len1, len2);
        // #deletion
        result[1] = len1 - lcs.length();
        // #insertion
        result[0] = len2 - lcs.length();
        return result;
    }
}

/*
heap
pea
 */