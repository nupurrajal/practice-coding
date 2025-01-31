package com.linkedin;

import java.util.Iterator;
import java.util.TreeSet;

public class CanArrayBePreorderOfBST {
    public static void main(String[] args) {
        int[] pre = new int[]{40, 30, 35, 80, 100};
        System.out.println(isPreorderBST(0, pre.length, pre, Integer.MIN_VALUE, Integer.MAX_VALUE));
        int[] postorder1 = {2, 4, 3, 6, 8, 7, 5}; // Valid BST postorder
        int[] postorder2 = {2, 4, 3, 8, 6, 7, 5}; // Invalid BST postorder
        int n1 = postorder1.length;
        int n2 = postorder2.length;
        System.out.println(isPostorderBST(0, n1-1, postorder1, Integer.MIN_VALUE, Integer.MAX_VALUE));
        System.out.println(isPostorderBST(0, n2-1, postorder2, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isPreorderBST(int index, int n, int[] pre, int min, int max) {
        if (index == n) {
            return true;
        }
        int root = pre[index];
        if (root <= min || root >= max) {
            return false;
        }
        int right = index+1;
        while (right < n && pre[right] < root) {
            right++;
        }
        return isPreorderBST(index+1, right, pre, min, root) && isPreorderBST(right, n, pre, root, max);
    }

    private static boolean isPostorderBST(int start, int end, int[] post, int min, int max) {
        if (start > end) {
            return true;
        }
        int root = post[end];
        if (root <= min || root >= max) {
            return false;
        }
        int left = end-1;
        while (left >= start && post[left] > root) {
            left--;
        }
        return isPostorderBST(start, left, post, min, root) && isPostorderBST(left+1, end-1, post, root, max);
    }
}
