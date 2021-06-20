package com.practice.greedy;

import java.util.Scanner;

public class MinNumberOfJumps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(printMinNumOfJumpsToEnd(arr, n));
        sc.close();
    }

    private static int printMinNumOfJumpsToEnd(int[] arr, int n) {
        int steps = 1, i = 0;
        while (i < n) {
            steps++;
            int currMax = 0;
            for (int k = i+1; k <= Math.min(i + arr[i], n-1); k++) {
                currMax = Math.max(currMax, arr[k]);
            }

            i += currMax+1;
        }
        return steps;
    }
}

/*
10
2 3 1 1 2 4 2 0 1 1

11
1 3 5 8 9 2 6 7 6 8 9
 */
