package com.practice.binarysearch;

import java.util.Arrays;
import java.util.Scanner;

public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);

        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target) {
            return result;
        }

        result[0] = low;

        high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        result[1] = low;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int nums[] = new int[n];
        for (int i = 0; i < n; i ++) {
            nums[i] = sc.nextInt();
        }
        int[] result = searchRange(nums, target);
        System.out.println("Range: " + result[0] + " " + result[1]);
        sc.close();
    }
}

/*
6 8
5 7 7 8 8 10
 */