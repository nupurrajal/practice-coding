package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class CountSubsetWithGivenDiff {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        /*
            s1 + s2 = range
            s2 - s1 = given
            ----------
            s2 = (range + given) / 2
         */
        int value = (Arrays.stream(array).sum() + diff);
        if (value % 2 == 0) {
            value /= 2;
            System.out.println(countSubsetWithGivenDiffDP(array, value, n));
        }
        else {
            System.out.println("NA");
        }
    }

    private static int countSubsetWithGivenDiffDP(int[] array, int sum, int n) {
        return CountSubsetSum.countSubsetSumDP(array, sum, n);
    }
}

