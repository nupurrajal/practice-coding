package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberOfMatchingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        List<String> input = new ArrayList<>();
        while (n-- > 0) {
            input.add(sc.next());
        }
        System.out.println(printNumberOfMatchingSubsequence(s, input));
    }

    private static int printNumberOfMatchingSubsequence(String s, List<String> words) {
        int count = 0;
        char[] sarr = s.toCharArray();
        int l1 = s.length();
        for (String word : words) {
            char[] warr = word.toCharArray();
            int i = 0, j = 0;
            int l2 = word.length();
            while (i < l1) {
                if (sarr[i] == warr[j]) {
                    i++;
                    j++;
                    if (j == l2) {
                        count++;
                        System.out.println(word);
                        break;
                    }
                } else {
                    i++;
                }
            }
        }
        return count;
    }
}

/*
4
abcde
a
bb
acd
ace

1
abcde
ace
 */
