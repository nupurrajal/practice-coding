package com.linkedin;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
        int target = 7;
        List<List<Integer>> result = new ArrayList<>();
        computeAllCombinationSum(0, new ArrayList<>(), target, nums, result);
        for (List<Integer> r : result) {
            for (Integer i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static void computeAllCombinationSum(int index, ArrayList<Integer> currSum, int target, int[] nums, List<List<Integer>> result) {
        if (index >= nums.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(currSum));
        }
        for (int i = index; i < nums.length; i++) {
            if (nums[i] <= target) {
                currSum.add(nums[i]);
                computeAllCombinationSum(i, currSum, target-nums[i], nums, result);
                currSum.remove(currSum.size()-1);
            }
        }
    }
}
