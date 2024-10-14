package com.practice.dp;

import java.util.Scanner;

// string made of T, F / | & ^

public class EvaluateExpressionToTrue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(printMaxWaysForTrueExpressionRecursive(s, 0, s.length()-1, true));
        sc.close();
    }

    private static int printMaxWaysForTrueExpressionRecursive(String s, int i, int j, boolean isTrue) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return isTrue ? boolToInt(s.charAt(i) == 'T') : boolToInt(s.charAt(i) == 'F');
        }
        int ans = 0;
        for (int k = i+1; k <= j-1; k+=2) {
            int lt = printMaxWaysForTrueExpressionRecursive(s, i, k-1, true);
            int lf = printMaxWaysForTrueExpressionRecursive(s, i, k-1, false);
            int rt = printMaxWaysForTrueExpressionRecursive(s, k+1, j, true);
            int rf = printMaxWaysForTrueExpressionRecursive(s, k+1, j, false);
            switch (s.charAt(k)) {
                case '&': if (isTrue) {
                            ans += lt*rt;
                          } else {
                            ans += lt*rf + lf*rt + lf*rf;
                          }
                          break;
                case '|': if (isTrue) {
                            ans += lt*rt + lt*rf + lf*rt;
                          } else {
                            ans += lf*rf;
                          }
                          break;
                case '^': if (isTrue) {
                            ans += lt*rf + lf*rt;
                          } else {
                            ans += lt*rt + lf*rf;
                          }
                          break;
            }
        }
        return ans;
    }

    private static int boolToInt(boolean b) {
        return b ? 1 : 0;
    }
}

/*
T|F&T^F
 */
