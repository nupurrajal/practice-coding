package com.linkedin;

public class Merge2SortedArrays {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2};
        int[] nums2 = new int[]{3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int total = A.length + B.length;
        int half = total / 2;
        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int l = 0, r = A.length;
        while (true) {
            int midA = (l+r)/2;
            int midB = half - midA;
            int ALeft = midA > 0 ? A[midA-1] : Integer.MIN_VALUE;
            int ARight = midA < A.length ? A[midA] : Integer.MAX_VALUE;
            int BLeft = midB > 0 ? B[midB-1] : Integer.MIN_VALUE;
            int BRight = midB < B.length ? B[midB] : Integer.MAX_VALUE;
            if (ALeft <= BRight && BLeft <= ARight) {
                if (total % 2 == 0) {
                    return (Math.max(ALeft, BLeft) + Math.min(ARight, BRight)) / 2.0;
                } else {
                    return 1.0 * Math.min(ARight, BRight);
                }
            } else if (ALeft > BRight) {
                r = midA-1;
            } else {
                l = midA+1;
            }
        }
    }
}
