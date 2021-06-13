package com.practice.leetcode;

import java.util.Scanner;

public class EggDropping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        System.out.println(minTries(N,E));
        sc.close();
    }

    private static int minTries(int n, int e) {
        if (n == 1) {
            return e;
        }
        if (e == 1) {
            return n;
        }
        return Math.min(minTries(n-1, e-1), minTries(n-1, e)) + 1;
    }
}
