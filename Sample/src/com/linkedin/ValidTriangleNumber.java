package com.linkedin;

import java.util.Arrays;

public class ValidTriangleNumber {
    public static void main(String[] args) {
        int[] arr = new int[]{2,2,3,4};
        int count = 0;
        Arrays.sort(arr);
        int n = arr.length;
        for (int i = 0; i < n-2; i++) {
            int k = i+2;
            for (int j = i+1; j < n-1; j++) {
                int side = arr[i] + arr[j];
                while (k < n && arr[k] < side) {
                    k++;
                }
                // k-1 - (j+1) + 1
                // because range of k will start with next j, not j.
                count += k - j - 1;
                // k-1 + 1 - j
            }
        }
        System.out.println(count);
    }
}
