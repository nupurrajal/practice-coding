package com.practice.leetcode;

import java.util.Scanner;

public class Binary {
    public static int countBinarySubstrings(String s) {
        int count = 0;
        if (s.length() <= 1)
            return count;
        char curr = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            int k = i;
            while (k < s.length() && s.charAt(k) == curr) {
                k++;
            }
            int currIndex = k;
            int tempcount = k - i + 1;
            k++;
            int revCount = 1;
            if (k < s.length()) {
                curr = s.charAt(k);
                while (k < s.length() && s.charAt(k) == curr) {
                    k++;
                    revCount++;
                }
                count += Math.min(revCount, tempcount);
                i = currIndex;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(countBinarySubstrings(s));
    }
}
