package com.linkedin;

public class FirstAndLastPosInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        int[] res = indicesOfFirstAndLastPostInSortedArray(nums, target);
        System.out.println(res[0] + " " + res[1]);
    }

    private static int[] indicesOfFirstAndLastPostInSortedArray(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int low = 0, high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (nums[low] != target) {
            return res;
        }
        res[0] = low;
        high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid;
            }
        }
        if (nums[high] != target) {
            return new int[]{-1, -1};
        }
        res[1] = high;
        return res;
    }
}
