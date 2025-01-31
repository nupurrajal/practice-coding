package com.linkedin;

// https://www.geeksforgeeks.org/k-th-element-two-sorted-arrays/
public class KthOf2Sorted {
    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        System.out.println(findKthBS(a, a.length, b, b.length, 5));
    }

    private static int findKth(int[] a, int n, int[] b, int m, int k) {
        int d = 0, i = 0, j = 0;
        while (i < n && j < m) {
            d++;
            if (a[i] < b[j]) {
                if (d == k) {
                    return a[i];
                }
                i++;
            } else {
                if (d == k) {
                    return b[j];
                }
                j++;
            }
        }
        while (i < n) {
            d++;
            if (d == k) {
                return a[i];
            }
            i++;
        }
        while (j < m) {
            d++;
            if (d == k) {
                return b[j];
            }
            j++;
        }
        return -1;
    }

    private static int findKthBS(int[] a, int n, int[] b, int m, int k) {
        int[] A = a, B = b;
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l = 0, r = Math.min(k, n);
        while (l <= r) {
            int i = l + (r - l) / 2;
            int j = k - i;
            int ALeft = i > 0 ? A[i-1] : Integer.MIN_VALUE;
            int ARight = i < n ? A[i] : Integer.MAX_VALUE;
            int BLeft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            int BRight = j < m ? B[j] : Integer.MAX_VALUE;
            if (ALeft <= BRight && BLeft <= ARight) {
                return Math.max(ALeft, BLeft);
            } else if (ALeft > BRight) {
                r = i-1;
            } else {
                l = i+1;
            }
        }
        return -1;
    }

}

