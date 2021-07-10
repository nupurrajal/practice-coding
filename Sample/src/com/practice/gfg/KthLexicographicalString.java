package com.practice.gfg;

import java.util.Scanner;

public class KthLexicographicalString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(printKthLexicographicalStringOfNSize(n, k));
        sc.close();
    }

    private static String printKthLexicographicalStringOfNSize(int n, int k) {
        StringBuilder result = new StringBuilder();
        int[] digit = new int[n];

        for (int i = n-1; i >= 0; i--) {
            digit[i] = k%26;
            k /= 26;
        }
        if (k > 0) {
            return "-1";
        }
        for (int num : digit) {
            result.append((char) (num+'a'));
        }
        return result.toString();
    }
}
