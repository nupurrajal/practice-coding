package com.linkedin;

import java.util.Scanner;

// Longest Prefix Suffix array
// LPS - we will take the longest prefix of a string which is also a suffix of the string
// https://youtube.com/watch?v=JoF0Z7nVSrA&t=1210s&ab_channel=NeetCode
public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String haystack = sc.next();
        String needle = sc.next();
        System.out.println(strStr(haystack, needle));
    }

    private static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int[] lps = getLPS(needle);
        int hInd = 0, nInd = 0;
        while (hInd < haystack.length()) {
            if (haystack.charAt(hInd) == needle.charAt(nInd)) {
                hInd++;
                nInd++;
            } else if (nInd == 0) {
                hInd++;
            } else {
                nInd = lps[nInd-1];
            }
            if (nInd == needle.length()) {
                return hInd - needle.length();
            }
        }
        return -1;
    }

    private static int[] getLPS(String needle) {
        int m = needle.length();
        int[] lps = new int[m];
        // length of previous longest prefix suffix
        // i is 1 as lps[0] will always be 0
        int prevLPS = 0, i = 1;
        while (i < m) {
            if (needle.charAt(i) == needle.charAt(prevLPS)) {
                lps[i] = ++prevLPS;
                i++;
            } else if (prevLPS == 0) {
                lps[i] = 0;
                i++;
            } else {
                prevLPS = lps[prevLPS - 1];
            }
        }
        return lps;
    }
}

/*
AAAXAAAA
AAAA


AAAXAAAA
AAAA

same size as needle
AAAA
LPS[0] = 0 - longest prefix (not entire string, maximum can be length-1, a proper prefix)
    and suffix is A at this position.
LPS[1] = A (at position 0 is prefix, A at position 1 is suffix)
LPS = [0,1,2,3]



Example 2
needle = AAACAAAA
         p
LPS = [0, 1, 2, 0, 1, ]
 */