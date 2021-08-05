package com.practice.dp;

import java.util.Scanner;

public class MaxRectInBinaryMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] binary = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                binary[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxAreaOfRectangle(n, m, binary));
        sc.close();
    }

    private static int maxAreaOfRectangle(int n, int m, int[][] binary) {

        return 0;
    }


}

/*
4 5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 */
