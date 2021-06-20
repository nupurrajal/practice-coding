package com.practice.gfg;

import java.util.Scanner;

public class MergeWoExtraSpace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }
        mergeWithoutExtraSpacesUtil(arr1, arr2, n, m);
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        sc.close();
    }

    private static void mergeWithoutExtraSpacesUtil(int[] arr1, int[] arr2, int n, int m) {
        int l = 0, r = 0;
        while (l < n) {
            if (arr1[l] > arr2[r]) {
                int temp = arr1[l];
                arr1[l] = arr2[r];
                arr2[r] = temp;
                int k = r+1;
                boolean flag = false;
                while (k < m && arr2[k] < temp) {
                    arr2[k-1] = arr2[k];
                    k++;
                    flag=true;
                }
                if (flag)
                    arr2[k-1] = temp;
                l++;
            }
            else {
                r++;
            }
        }
    }
}
/*
4 5
1 3 5 7
0 2 6 8 9
 */