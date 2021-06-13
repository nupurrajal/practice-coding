package com.practice.leetcode;

import java.util.Scanner;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int length = nums.length;
        int high = length - 1;
        int low = 0;
        while(low < high) {
            while (nums[high] == val) {
                high--;
            }
            if (nums[low] == val) {
                nums[low] = nums[high];
                nums[high] = val;
                high--;
            }
            low++;
        }
        System.out.println(high + " " + low);
        for (int i : nums)
            System.out.print(i + " ");
        System.out.println();
        return high + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int val = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        System.out.println(removeElement(A, val));
    }
}
