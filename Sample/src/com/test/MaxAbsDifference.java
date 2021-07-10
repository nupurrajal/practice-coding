package com.test;

import java.util.Scanner;

public class MaxAbsDifference {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = i+1;
            }
            System.out.println(chocolateProblem(n, arr));
        }
        sc.close();
    }

    private static int chocolateProblem(int n, int[] arr) {
        int maxSum = 0;
        int k = 0;
        int[] res = new int[n];
        for (int i = 0; i < n/2; i++) {
            res[k++] = arr[i];
            res[k++] = arr[n-i-1];
        }
        if (n%2 != 0) {
            res[k] = arr[n/2];
        }
        for (int i = 0; i < n-1; i++) {
            maxSum += Math.abs(res[i]-res[i+1]);
        }
        return maxSum;
    }
}
