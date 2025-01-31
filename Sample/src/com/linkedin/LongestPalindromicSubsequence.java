package com.linkedin;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s1 = "GEEKSFORGEEKS";
        String s2 = "BBABCBCAB";
        System.out.println(lps(s1, 0, s1.length()-1));
        Integer[][] memo = new Integer[s2.length()][s2.length()];
        System.out.println(lpsMemo(s2, 0, s2.length()-1, memo));
    }

    private static int lps(String s, int i, int j) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            return 2 + lps(s, i+1, j-1);
        }
        return Math.max(lps(s, i+1, j), lps(s, i, j-1));
    }

    private static int lpsMemo(String s, int i, int j, Integer[][] memo) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 1;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return memo[i][j] = 2 + lps(s, i+1, j-1);
        }
        return memo[i][j] = Math.max(lps(s, i+1, j), lps(s, i, j-1));
    }
}
