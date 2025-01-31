package com.linkedin;

import java.util.Arrays;
import java.util.Collections;

public class KPartitionSubsetSum {
    public static void main(String[] args) {
//        int[] nums = new int[]{4,3,2,3,5,2,1};
//        int k = 4;
        int[] nums = new int[]{1,2,3,4};
        int k = 3;
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) {
            System.out.println("Not possible");
            System.exit(0);
        }
        Integer[] numsI = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(numsI, Collections.reverseOrder());
        System.out.println(isSubSetSumPossible(numsI, 0, 0, total/k, k, new boolean[nums.length]));
    }

    private static boolean isSubSetSumPossible(Integer[] nums, int index, int currSum, int totalSum, int k, boolean[] visited) {
        if (k == 0) {
            return true;
        }
        if (currSum == totalSum) {
            return isSubSetSumPossible(nums, 0, 0, totalSum, k-1, visited);
        }
        for (int i = index; i < nums.length; i++) {
            if (visited[i] || currSum + nums[i] > totalSum) {
                continue;
            }
            visited[i] = true;
            if (isSubSetSumPossible(nums, i + 1, nums[i] + currSum, totalSum, k, visited)) {
                return true;
            }
            visited[i] = false;
        }
        return false;
    }

}
