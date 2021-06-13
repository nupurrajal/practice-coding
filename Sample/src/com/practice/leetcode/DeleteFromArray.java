package com.practice.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteFromArray {

    private static int deleteNumInArray(Integer[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int val = sc.nextInt();
        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        deleteNumInArray(nums, val);
        System.out.println(Arrays.deepToString((Object[]) nums));
    }
}
