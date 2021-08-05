package com.practice.dp;

import java.util.Scanner;

public class RegularExpressionMatching {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        System.out.println(isMatch(s, p));
        sc.close();
    }

    private static boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl+1][pl+1];
        dp[0][0] = true;
        for (int i = 1; i <= pl; i++) {
            dp[0][i] = p.charAt(i-1) == '*' ? dp[0][i-2] : false;
        }

        for (int i = 1; i <= sl; i++) {
            for (int j = 1; j <= pl; j++) {
                if (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    dp[i][j] = dp[i][j-2];
                    if (p.charAt(j-2) == '.' || p.charAt(j-2) == s.charAt(i-1)) {
                        dp[i][j] |= dp[i-1][j];
                    }
                }
            }
        }
        return dp[sl][pl];
    }
}
