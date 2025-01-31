package com.linkedin;

public class PartitionToKEqualSubsets {
    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,3,5,2,1};
        int k = 4;
        System.out.println(possibleToPartitionToKEqualSubsets(nums, k));
    }

    private static boolean possibleToPartitionToKEqualSubsets(int[] nums, int k) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }
        if (total % k != 0) {
            return false;
        }
        return possibleToPartitionToKEqualSubsets(nums, k, 0, total/k, 0, new boolean[nums.length]);
    }

    private static boolean possibleToPartitionToKEqualSubsets(int[] nums, int k, int currSum, int sumPerSet, int index, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (currSum == sumPerSet) {
            return possibleToPartitionToKEqualSubsets(nums, k-1, 0, sumPerSet, 0, visited);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > sumPerSet) {
                continue;
            }
            visited[i] = true;
            if (possibleToPartitionToKEqualSubsets(nums, k, currSum + nums[i], sumPerSet, i+1, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
