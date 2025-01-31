package com.linkedin;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println(maxSum(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int maxSum(int[] nums) {
        int sum = nums[0], maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum + nums[i] < nums[i]) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            maxSoFar = Math.max(maxSoFar, sum);
        }
        return maxSoFar;
    }
}
