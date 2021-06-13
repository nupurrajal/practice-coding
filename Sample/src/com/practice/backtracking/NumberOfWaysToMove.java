package com.practice.backtracking;

import java.util.Scanner;

public class NumberOfWaysToMove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(countWaysToMove(m-1, n-1));
        sc.close();
    }

    private static int countWaysToMove (int m, int n) {
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        return countWaysToMove(m-1, n) + countWaysToMove(m, n-1);
    }
}
