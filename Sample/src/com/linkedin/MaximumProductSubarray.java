package com.linkedin;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr1 = {-2, 3, 4, -1, 0, -2, 3, 1, 4, 0, 4, 6, -1, 4};
        int[] arr2 = {1, -2, -3, 0, -4, -5};

        System.out.println(getMaxProduct(arr1));
        System.out.println(getMaxProduct(arr2));
    }

    private static int getMaxProduct(int[] arr) {
        int pre = 1, suff = 1;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (pre == 0) {
                pre = 1;
            }
            pre *= arr[i];
            if (suff == 0) {
                suff = 1;
            }
            suff *= arr[arr.length-i-1];
            result = Math.max(result, Math.max(pre, suff));
        }
        return result;
    }
}
