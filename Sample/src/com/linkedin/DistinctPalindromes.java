package com.linkedin;

import java.util.HashSet;
import java.util.Set;

public class DistinctPalindromes {
    public static void main(String[] args) {
        String s = "abaaa";
        Set<String> result = getPalindromes(s);
        for (String r : result) {
            System.out.print(r + " ");
        }
    }

    private static Set<String> getPalindromes(String s) {
        if (s.isEmpty()) {
            return new HashSet<>();
        }
        Set<String> res = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            getPalindromes(s, i, i, res);
            getPalindromes(s, i, i+1, res);
        }
        return res;
    }

    private static void getPalindromes(String s, int l, int r, Set<String> res) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res.add(s.substring(l, r+1));
            l--;
            r++;
        }
    }

    private static Set<String> getPalindromesDP(String s) {
        if (s.isEmpty()) {
            return new HashSet<>();
        }
        Set<String> res = new HashSet<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            res.add(s.substring(i,i+1));
        }
        for (int i = 0; i < n-1; i++) {

        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (dp[s.length()-1][i]) {

            }
        }
        return res;
    }
}
