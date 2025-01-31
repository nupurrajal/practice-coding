package com.linkedin;

public class SortTransformedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{-4, -2, 2, 4};
        int a = 1, b= 3, c = 5;
        int[] result = getSortedArrayAfterTransformation(nums, a, b, c);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] getSortedArrayAfterTransformation(int[] nums, int a, int b, int c) {
        int n = nums.length, left = 0, right = n-1;
        int index = a >= 0 ? n-1 : 0;
        int[] result = new int[n];
        while (left <= right) {
            int tLeft = getTransformed(nums[left], a, b, c);
            int tRight = getTransformed(nums[right], a, b, c);
            if (a > 0) {
                if (tLeft > tRight) {
                    result[index--] = tLeft;
                    left++;
                } else {
                    result[index--] = tRight;
                    right--;
                }
            } else {
                if (tLeft < tRight) {
                    result[index++] = tLeft;
                    left++;
                }  else {
                    result[index++] = tRight;
                    right--;
                }
            }
        }
        return result;
    }

    private static int getTransformed(int num, int a, int b, int c) {
        return a * num * num + b * num + c;
    }
}
