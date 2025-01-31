package com.linkedin;

import java.util.*;

// https://leetcode.com/problems/sliding-window-maximum/solutions/458121/java-all-solutions-b-f-pq-deque-dp-with-explanation-and-complexity-analysis/
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] res = maxSlidingWindowEasy(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] maxSlidingWindowEasy(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();  // stores *indices*
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!q.isEmpty() && nums[q.getLast()] <= nums[i]) {
                q.removeLast();
            }
            q.addLast(i);
            // remove first element if it's outside the window
            if (q.getFirst() == i - k) {
                q.removeFirst();
            }
            // if window has k elements add to results (first k-1 windows have < k elements because we start from empty window and add 1 element each iteration)
            if (i >= k - 1) {
                res.add(nums[q.peek()]);
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        if (k > nums.length) {
            return new int[]{};
        }
        int n = nums.length;
        int[] result = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i-k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            if (i >= k-1) {
                result[i-k+1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
