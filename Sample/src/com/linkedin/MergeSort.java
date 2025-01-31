package com.linkedin;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = {5,3,2,6,9,1,2};
        mergeSort(nums, 0, nums.length-1);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int m = low + (high-low) / 2;
        mergeSort(nums, low, m);
        mergeSort(nums, m+1, high);

        mergeSortUtil(nums, low, m, high);
    }

    private static void mergeSortUtil(int[] nums, int low, int m, int high) {
        int n1 = m - low + 1;
        int n2 = high - m;
        int[] A = new int[n1];
        int[] B = new int[n2];
        System.arraycopy(nums, low, A, 0, n1);
        System.arraycopy(nums, m+1, B, 0, n2);
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (A[i] < B[j]) {
                nums[k++] = A[i++];
            } else {
                nums[k++] = B[j++];
            }
        }
        while (i < n1) {
            nums[k++] = A[i++];
        }
        while (j < n2) {
            nums[k++] = B[j++];
        }
    }
}
