package com.practice.binarysearch;

import java.util.Scanner;

public class MRootOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(m + "th root of " + n + " = " + findMthRoot(n, m));
        sc.close();
    }

    private static double findMthRoot (int n, int m) {
        double low = 1;
        double high = n;
        double precision = 1e-6;
        while ((high - low) > precision) {
            double mid = (low + high) / 2;
            if (Math.pow(mid, m) < n) {
                low = mid;
            } else {
                high = mid;
            }
        }
        System.out.println("Verify: " + Math.pow(high, m));
        return high;
    }
}
